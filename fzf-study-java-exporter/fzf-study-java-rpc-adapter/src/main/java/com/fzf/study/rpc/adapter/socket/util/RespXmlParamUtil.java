package com.fzf.study.rpc.adapter.socket.util;


import com.fzf.study.rpc.adapter.socket.constant.Constants;
import com.fzf.study.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;

import java.io.IOException;

public class RespXmlParamUtil {


    public static CoreMessage replyIllegalRequestOrParam(ResponseAbstractEnum responseAbstract, DOMXMLReader domxmlReader, String errDesc) throws IllegalAccessException, IOException {
        StringBuffer respXml = new StringBuffer();
        RespXMlGenerator.appendResHead(respXml, responseAbstract, domxmlReader, errDesc);
        RespXMlGenerator.appendResBody(respXml, responseAbstract, null, null);
        String processRespXml = respXml.toString();
        if (!XmlUtils.formatXml(processRespXml)) {
            processRespXml = processRespXml.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
            XmlUtils.formatXml(processRespXml);
        }
        CoreMessage respMsg = new CoreMessage();
        respMsg.getCustomAttributes().put(Constants.MESSAGE_KEY, processRespXml);
        return respMsg;
    }


    public static <T> CoreMessage getCoreMessage(DOMXMLReader domxmlReader, T object, Class<? super T> clazz) throws IllegalAccessException, IOException {
        StringBuffer respXml = new StringBuffer();
        RespXMlGenerator.appendResHead(respXml, ResponseAbstractEnum.SUCCESS, domxmlReader, "");
        RespXMlGenerator.appendResBody(respXml, ResponseAbstractEnum.SUCCESS, object, clazz);
        String processRespXml = respXml.toString();
        if (!XmlUtils.formatXml(processRespXml)) {
            processRespXml = processRespXml.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
            XmlUtils.formatXml(processRespXml);
        }
        CoreMessage coreMassage = new CoreMessage();
        coreMassage.getCustomAttributes().put(Constants.MESSAGE_KEY, processRespXml);
        return coreMassage;
    }

}
