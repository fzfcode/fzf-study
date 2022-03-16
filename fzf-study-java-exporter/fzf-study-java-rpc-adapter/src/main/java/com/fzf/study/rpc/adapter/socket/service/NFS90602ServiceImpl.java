/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.service;

import com.sankuai.meituan.mkt.activity.dictionary.exception.MktException;
import com.sankuai.meituan.mkt.activity.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.sankuai.meituan.mkt.activity.dictionary.rpc.PlainResponse;
import com.sankuai.meituan.mkt.activity.domain.common.MktActivityAssertUtils;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.request.CardActivationInviteSocketRequest;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXmlParamUtil;
import com.sankuai.meituan.mkt.activity.rpc.adapter.support.mt.normandy.CardActivationInviteSmsSocketExporter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 11:13 上午
 * @description: 90602服务
 */
@Service(Constants.QD_90602)
@NFSServiceId(type = Constants.QD_90602)
public class NFS90602ServiceImpl implements NFSService {

    private static final int QD_90602_LIMIT = 50;

    @Resource
    private CardActivationInviteSmsSocketExporter cardActivationInviteSmsSocketExporter;

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {
        String serviceSn = domxmlReader.getValueFromReqServiceHead("SERVICE_SN").trim();
        List<String> applyNos = domxmlReader.getListFromReqServiceBody("APPLY_NO");
        String labelType = domxmlReader.getValueFromReqServiceBody("LABEL_TYPE");
        String sendType = domxmlReader.getValueFromReqServiceBody("SEND_TYPE");

        CardActivationInviteSocketRequest request = CardActivationInviteSocketRequest.builder()
                .serviceSn(serviceSn).applyNos(applyNos).labelType(labelType).sendType(sendType).build();
        try {
            //请求参数校验
            checkRequest(request);
        } catch (MktException mktException) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, mktException.getMessage());
        }
        //查询卡片申请信息
        PlainResponse<String> plainResponse = cardActivationInviteSmsSocketExporter.inviteCardActivation(request);
        if (!plainResponse.isSuccess()) {
            ResponseAbstractEnum responseAbstractEnum = ResponseAbstractEnum.SERVERROR;
            responseAbstractEnum.resCode = String.valueOf(plainResponse.getCode());
            return RespXmlParamUtil.replyIllegalRequestOrParam(responseAbstractEnum, domxmlReader, plainResponse.getMessage());
        }
        return RespXmlParamUtil.getCoreMessage(domxmlReader, null, null);
    }

    private void checkRequest(CardActivationInviteSocketRequest request) {

        MktActivityAssertUtils.assertNotNull(request.getApplyNos(), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "缺失请求参数[APPLY_NO]");

        MktActivityAssertUtils.assertTrue(request.getApplyNos().size()>0, CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "缺失请求参数[APPLY_NO]");

        MktActivityAssertUtils.assertTrue(StringUtils.isNotBlank(request.getLabelType()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "缺失请求参数[LABEL_TYPE]");

        MktActivityAssertUtils.assertTrue(request.getApplyNos().size() <= QD_90602_LIMIT, CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "请求参数[APPLY_NO]不得大于" + QD_90602_LIMIT);

    }
}
