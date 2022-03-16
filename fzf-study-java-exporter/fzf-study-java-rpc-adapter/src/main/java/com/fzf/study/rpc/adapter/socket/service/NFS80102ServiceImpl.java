package com.fzf.study.rpc.adapter.socket.service;

import com.alibaba.fastjson.JSON;
import com.sankuai.meituan.mkt.activity.application.signup.ActivitySignUpAppService;
import com.sankuai.meituan.mkt.activity.application.signup.ActivitySignUpQueryRequest;
import com.sankuai.meituan.mkt.activity.application.signup.ActivitySignUpQueryResponse;
import com.sankuai.meituan.mkt.activity.common.utils.BeanUtils;
import com.sankuai.meituan.mkt.activity.dictionary.enums.ActivitySignUpMemberTypeEnum;
import com.sankuai.meituan.mkt.activity.dictionary.exception.MktException;
import com.sankuai.meituan.mkt.activity.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.sankuai.meituan.mkt.activity.domain.common.MktActivityAssertUtils;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.response.ActivitySignUpQuerySocketResponse;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXmlParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service(Constants.SIGN_UP_80102)
@NFSServiceId(type = Constants.SIGN_UP_80102)
@Slf4j
public class NFS80102ServiceImpl implements NFSService {

    @Resource
    ActivitySignUpAppService activitySignUpAppService;

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {

        String requestObject = domxmlReader.getValueFromReqServiceBody("REQUEST_OBJECT");

        try {
            MktActivityAssertUtils.assertNotNull(requestObject, CommonResponseCodeEnum.REQUEST_IS_NULL);

            ActivitySignUpQueryRequest signUpQueryRequest = JSON.parseObject(requestObject, ActivitySignUpQueryRequest.class);

            checkRequest(signUpQueryRequest);

            ActivitySignUpQueryResponse signUpQueryResponse = activitySignUpAppService.query(signUpQueryRequest);

            ActivitySignUpQuerySocketResponse signUpQuerySocketResponse = BeanUtils.clone(signUpQueryResponse, ActivitySignUpQuerySocketResponse.class);

            return RespXmlParamUtil.getCoreMessage(domxmlReader, signUpQuerySocketResponse, ActivitySignUpQuerySocketResponse.class);
        } catch (MktException mktException) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, mktException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("接口信息:{},请求信息:{},异常信息:{},", Constants.SIGN_UP_80102, requestObject, e);
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.SERVERROR, domxmlReader, "服务未知异常");
        }

    }


    private void checkRequest(ActivitySignUpQueryRequest signUpQueryRequest)
            throws MktException {

        MktActivityAssertUtils.assertTrue(StringUtils.isNotBlank(signUpQueryRequest.getActivityId().toString()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "报名活动ID不能为空");

        MktActivityAssertUtils.assertNotNull(ActivitySignUpMemberTypeEnum.getMemberTypeEumByValue(signUpQueryRequest.getSignUpMemberType()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "报名号类型有误");

        MktActivityAssertUtils.assertTrue(StringUtils.isNotBlank(signUpQueryRequest.getSignUpMemberNo()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "报名号不能为空");
    }

}
