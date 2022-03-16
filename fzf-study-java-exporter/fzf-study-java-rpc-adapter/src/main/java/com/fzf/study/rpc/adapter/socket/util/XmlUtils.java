package com.fzf.study.rpc.adapter.socket.util;



import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.RespXmlElement;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.RespXmlListElement;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ProcessFieldEnum;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.List;

public class XmlUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

    public static String parseBeanToXml(Class clazz, Object bean) throws IllegalAccessException {
        StringBuffer xmlStr = new StringBuffer();
        boolean needRootTag = false;
        String rootTagName = "";
        if (clazz.isAnnotationPresent(RespXmlElement.class)) {
            rootTagName = ((RespXmlElement) clazz.getAnnotation(RespXmlElement.class)).elementName();
            if (StringUtils.isNotBlank(rootTagName)) {
                needRootTag = true;
                xmlStr.append("<" + rootTagName + ">");
            }
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(RespXmlListElement.class)) {
                String elementName = field.getAnnotation(RespXmlListElement.class).elementName();
                Class subClazz = field.getAnnotation(RespXmlListElement.class).subType();
                xmlStr.append("<" + elementName + ">");
                List subBeans = (List) field.get(bean);
                for (Object subBean : subBeans) {
                    xmlStr.append(parseBeanToXml(subClazz, subBean));
                }
                xmlStr.append("</" + elementName + ">");
            } else if (field.isAnnotationPresent(RespXmlElement.class)) {
                String elementName = field.getAnnotation(RespXmlElement.class).elementName();
                xmlStr.append("<" + elementName + ">");
                Object propValue = field.get(bean);
                if (null != propValue) {
                    xmlStr.append(propValue);
                }
                xmlStr.append("</" + elementName + ">");
            }
        }
        if (needRootTag) {
            xmlStr.append("</" + rootTagName + ">");
        }
        return xmlStr.toString();
    }


    public static boolean formatXml(String xml) throws IOException {

        Document document = null;
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("gb2312");
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);

        try {
            for(ProcessFieldEnum label: ProcessFieldEnum.values()){
                xml=xmlReplaceFiled(xml,label.getLabel(),label.getType());
            }
            document = DocumentHelper.parseText(xml);
            xmlWriter.write(document);
            LOGGER.info("回复请求，报文内容：\n {} ", writer.toString());
            return true;
        } catch (Exception e) {
            LOGGER.error("format xml exception，xml：{} ,error message is：{}", xml, e);
            return false;
        } finally {
            xmlWriter.close();
            writer.close();
        }
    }

    public static String xmlReplaceFiled(String xml,String filedName,int type){
        try {
            if (xml.contains(filedName)) {
                DOMXMLReader domxmlReader = new DOMXMLReader(xml, Constants.CHARSET_NAME_UTF8);
                List<String> filedList = domxmlReader.getListFromReqServiceBody(filedName);
                for(String value:filedList){
                    xml = CodeMarkUtils.xmlReplace2(xml, filedName, value, type);
                }
            }
        }catch (Exception e){
            LOGGER.warn("脱敏处理失败，字段名称：{},错误信息：{}", filedName,e);
        }
        return xml;
    }
}


