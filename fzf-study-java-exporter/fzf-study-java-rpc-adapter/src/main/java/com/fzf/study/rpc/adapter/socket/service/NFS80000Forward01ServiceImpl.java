package com.fzf.study.rpc.adapter.socket.service;

import com.alibaba.fastjson.JSON;
import com.sankuai.meituan.mkt.activity.application.support.bank.invitation.request.CardInvitationCountQueryEmployeeRequest;
import com.sankuai.meituan.mkt.activity.application.support.bank.invitation.response.CardInvitationCountQueryResponse;
import com.sankuai.meituan.mkt.activity.application.support.bank.invitation.service.CardApplyInvitationQueryService;
import com.sankuai.meituan.mkt.activity.dictionary.exception.MktException;
import com.sankuai.meituan.mkt.activity.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.sankuai.meituan.mkt.activity.domain.common.MktActivityAssertUtils;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.response.CardInvitationCountSocketResponse;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXmlParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service(Constants.QD_80000_01)
@NFSServiceId(type = Constants.QD_80000_01)
@Slf4j
public class NFS80000Forward01ServiceImpl implements NFSService {

    @Resource
    CardApplyInvitationQueryService cardApplyInvitationQueryService;

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {

        String requestObject = domxmlReader.getValueFromReqServiceBody("REQUEST_OBJECT");

        try {
            MktActivityAssertUtils.assertNotNull(requestObject, CommonResponseCodeEnum.REQUEST_IS_NULL);

            CardInvitationCountQueryEmployeeRequest queryEmployeeRequest = JSON.parseObject(requestObject, CardInvitationCountQueryEmployeeRequest.class);

            MktActivityAssertUtils.assertTrue(StringUtils.isNotBlank(queryEmployeeRequest.getBankEmployeeNo()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "行员编号不能为空");

            CardInvitationCountQueryResponse response = cardApplyInvitationQueryService.queryCardInvitationCountByEmployeeNo(queryEmployeeRequest);

            CardInvitationCountSocketResponse countSocketResponse = new CardInvitationCountSocketResponse();
            BeanUtils.copyProperties(response, countSocketResponse);

            return RespXmlParamUtil.getCoreMessage(domxmlReader, countSocketResponse, CardInvitationCountSocketResponse.class);
        } catch (MktException mktException) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, mktException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("接口信息:{},请求信息:{},异常信息:{},", Constants.QD_80000_01, requestObject, e);
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.SERVERROR, domxmlReader, "服务未知异常");
        }

    }

}
