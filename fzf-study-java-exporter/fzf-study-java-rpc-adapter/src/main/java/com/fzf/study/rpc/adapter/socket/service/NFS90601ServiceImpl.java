/*
  Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.service;

import com.sankuai.meituan.mkt.activity.dictionary.rpc.PlainResponse;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.response.CardApplyInfoInquirySocketResponse;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXmlParamUtil;
import com.sankuai.meituan.mkt.activity.rpc.adapter.support.mt.normandy.CardApplyInfoInquirySocketExporter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/17 4:04 下午
 * @description: 90601服务
 */
@Service(Constants.QD_90601)
@NFSServiceId(type = Constants.QD_90601)
public class NFS90601ServiceImpl implements NFSService {
    private static final int QD_90601_LIMIT = 50;
    @Resource
    private CardApplyInfoInquirySocketExporter cardApplyInfoInquirySocketExporter;

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {

        List<String> applyNos = domxmlReader.getListFromReqServiceBody("APPLY_NO");
        //校验申请编号
        if (CollectionUtils.isEmpty(applyNos)) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, "缺失请求参数[APPLY_NO]");
        }
        if (applyNos.size() > QD_90601_LIMIT) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, "请求参数[APPLY_NO]不得大于" + QD_90601_LIMIT);
        }
        //查询卡片申请信息
        PlainResponse<CardApplyInfoInquirySocketResponse> plainResponse = cardApplyInfoInquirySocketExporter.queryCardApplyInfo(applyNos);
        if (!plainResponse.isSuccess()) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.SERVERROR, domxmlReader, plainResponse.getMessage());
        }
        //返回报文处理
        CardApplyInfoInquirySocketResponse response = plainResponse.getData();
        return RespXmlParamUtil.getCoreMessage(domxmlReader, response, CardApplyInfoInquirySocketResponse.class);
    }
}
