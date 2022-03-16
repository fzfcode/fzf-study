package com.fzf.study.rpc.adapter.socket.util;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMXMLReader {

    /**
     * xml内容模板:
     * <?xml version='1.0' encoding='UTF-8'?>
     * <ROOT><HEAD></HEAD><BODY><ORG>000000000001</ORG></BODY></ROOT>
     */
    private String xmlContent;
    private String charset;
    private Element element;
    private Element appHead;

    public DOMXMLReader(String xmlContent, String charset)
            throws ParserConfigurationException,
            SAXException, IOException {
        this.xmlContent = xmlContent;
        this.charset = charset;
        init();
    }

    private void init() throws ParserConfigurationException
            , IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        dbf.setFeature("http://xml.org/sax/features/external-general-entities",
                false);
        dbf.setFeature("http://xml.org/sax/features/external-parameter-entities",
                false);
        Document document = db.parse(new InputSource(new ByteArrayInputStream(xmlContent.getBytes(charset))));
        Element root = document.getDocumentElement();//得到根节点
        element = (Element) root.getElementsByTagName(Constants.REQ_SERVICE_BODY).item(0);
        appHead = (Element) root.getElementsByTagName(Constants.REQ_SERVICE_HEADER).item(0);
    }

    /**
     * 获取报文体中指定标签值
     *
     * @param tagName 标签名
     * @return
     */
    public String getValueFromReqServiceHead(String tagName) {
        String value = "";
        Node node = appHead.getElementsByTagName(tagName).item(0);
        if (node != null) {
            value = node.getTextContent();
        }
        return value;
    }

    public List<String> getListFromReqServiceBody(String tagName) {
        List<String> reqValues = new ArrayList<>();
        if (element != null && element.getElementsByTagName(tagName) != null
                && element.getElementsByTagName(tagName).getLength() > 0) {
            NodeList nodes = element.getElementsByTagName(tagName);
            for (int i = 0; i < nodes.getLength(); i++) {
                reqValues.add(nodes.item(i).getTextContent());
            }
        }
        return reqValues;
    }

    public String getValueFromReqServiceBody(String tagName) {
        String value = "";
        if (element != null && element.getElementsByTagName(tagName) != null
                && element.getElementsByTagName(tagName).getLength() > 0) {
            Node node = element.getElementsByTagName(tagName).item(0);
            if (node != null) {
                value = node.getTextContent();
            }
        }
        if (StringUtils.isEmpty(value)) {
            value = "";
        }
        return value;
    }
}
