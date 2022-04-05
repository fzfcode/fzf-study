package com.fzf.study.rpc.adapter.socket.util;


import com.fzf.study.rpc.adapter.socket.constant.Constants;
import com.fzf.study.rpc.adapter.socket.enums.ResponseAbstractEnum;
import org.apache.commons.lang3.StringUtils;

public class RespXMlGenerator {
    /**
     * XML响应报文填充响应报文头
     *
     * @param respXml
     * @param responseCode
     * @param reqXmlReader
     * @param extDesc
     */
    public static void appendResHead(StringBuffer respXml, ResponseAbstractEnum responseCode, DOMXMLReader reqXmlReader, String extDesc) {
        respXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        respXml.append("<SERVICE xmlns=\"http://www.allinfinance.com/dataspec/\">");
        respXml.append("<SERVICE_HEADER>");
        respXml.append("<SERVICE_SN>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("SERVICE_SN"));
        respXml.append("</SERVICE_SN>");
        respXml.append("<SERVICE_ID>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("SERVICE_ID"));
        respXml.append("</SERVICE_ID>");
        respXml.append("<CHANNEL_ID>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("CHANNEL_ID"));
        respXml.append("</CHANNEL_ID>");
        respXml.append("<OP_ID>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("OP_ID"));
        respXml.append("</OP_ID>");
        respXml.append("<REQUST_TIME>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("REQUST_TIME"));
        respXml.append("</REQUST_TIME>");
        respXml.append("<VERSION_ID>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("VERSION_ID"));
        respXml.append("</VERSION_ID>");
        respXml.append("<MAC>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("MAC"));
        respXml.append("</MAC>");
        respXml.append("<RES_SERVICE_SN>");
        respXml.append(reqXmlReader.getValueFromReqServiceHead("SERVICE_SN"));
        respXml.append("</RES_SERVICE_SN>");
        respXml.append("<RES_SERVICE_TIME>");
        respXml.append("</RES_SERVICE_TIME>");
        respXml.append("<SERV_RESPONSE>");
        respXml.append("<STATUS>");
        respXml.append(responseCode.resType);
        respXml.append("</STATUS>");
        respXml.append("<CODE>");
        respXml.append(responseCode.resCode);
        respXml.append("</CODE>");
        respXml.append("<DESC>");
        respXml.append(responseCode.descTitle + (StringUtils.isNotBlank(extDesc) ? "-" + extDesc.trim() : ""));
        respXml.append("</DESC>");
        respXml.append("</SERV_RESPONSE>");
        respXml.append("</SERVICE_HEADER>");
    }

    /**
     * XML响应报文填充响应报文体
     *
     * @param respXml
     * @param responseCode
     * @param response
     * @param respClazz
     */
    public static <T> void appendResBody(StringBuffer respXml, ResponseAbstractEnum responseCode, T response, Class<? super T> respClazz) throws IllegalAccessException {
        respXml.append("<SERVICE_BODY>");
        respXml.append("<EXT_ATTRIBUTES>");
        respXml.append("</EXT_ATTRIBUTES>");
        respXml.append("<RESPONSE>");
        if (Constants.RES_TYPE_SUCC.equalsIgnoreCase(responseCode.resType) && response != null) {
            //添加响应报文体实际内容
            assert response != null;
            assert response.getClass().isAssignableFrom(respClazz);
            respXml.append(XmlUtils.parseBeanToXml(respClazz, response));
        }
        respXml.append("</RESPONSE>");
        respXml.append("</SERVICE_BODY>");
        respXml.append("</SERVICE>\r\n");
    }

}


