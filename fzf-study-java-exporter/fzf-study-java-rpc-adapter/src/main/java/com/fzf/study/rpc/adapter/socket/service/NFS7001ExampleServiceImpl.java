package com.fzf.study.rpc.adapter.socket.service;

import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.request.RequestParamEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.response.Resss;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RequestParamCheckUtil;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXmlParamUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(Constants.QD_70001)
@NFSServiceId(type = Constants.QD_70001)
public class NFS7001ExampleServiceImpl implements NFSService {


    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {

        CoreMessage coreMessage = RequestParamCheckUtil.checkParams(domxmlReader, RequestParamEnum.CARD_NO, RequestParamEnum.CARD_NO);
        if (coreMessage != null) return coreMessage;

        Resss resss = new Resss();
        return RespXmlParamUtil.getCoreMessage(domxmlReader, resss, Resss.class);
    }
}
