package com.fzf.study.rpc.adapter.socket.handler;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.factory.NFSServiceFactory;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.service.NFSService;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXMlGenerator;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RequestDispatchIoHandler extends IoHandlerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestDispatchIoHandler.class);


    @Resource
    NFSServiceFactory nfsServiceFactory;


    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        LOGGER.info("会话超时，关闭当前网络连接");
        session.closeNow();
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        LOGGER.error("报文接收异常", cause);
    }


    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        LOGGER.info("RequestDispatchHandler receive request,excute messageReceived method");
        long startTime = System.currentTimeMillis();

        CoreMessage receivedMsg = (CoreMessage) message;
        String msgContent = (String) receivedMsg.getCustomAttributes().get(Constants.MESSAGE_KEY);
        XmlUtils.formatXml(msgContent);
        DOMXMLReader domxmlReader = new DOMXMLReader(msgContent, Constants.CHARSET_NAME_UTF8);

        try {
            String reqServiceId = domxmlReader.getValueFromReqServiceHead(Constants.REQ_SERVICE_ID).trim();
            String mktServiceId = domxmlReader.getValueFromReqServiceBody(Constants.MARKETING_SERVICE_ID).trim();
            if (StringUtils.isBlank(reqServiceId)) {
                LOGGER.warn("请求中没有明确请求[交易编码SERVICE_ID]");
                StringBuffer respXml = new StringBuffer();
                RespXMlGenerator.appendResHead(respXml, ResponseAbstractEnum.ILLEGALREQ, domxmlReader, "缺失SERVICE_ID");
                RespXMlGenerator.appendResBody(respXml, ResponseAbstractEnum.ILLEGALREQ, null, null);
                CoreMessage respMsg = new CoreMessage();
                respMsg.getCustomAttributes().put(Constants.MESSAGE_KEY, respXml.toString());
                session.write(respMsg);
            } else {
                if (StringUtils.isNotBlank(mktServiceId)) {
                    reqServiceId = mktServiceId;
                }
                NFSService nfsService = nfsServiceFactory.getInstance(reqServiceId);
                CoreMessage coreMessage=nfsService.process(domxmlReader);
                session.write(coreMessage);
            }
            long endTime = System.currentTimeMillis();
            LOGGER.info(reqServiceId + "cost time : {} ms", endTime - startTime);
        } catch (Exception e) {
            LOGGER.error("RequestDispatchHandler receive request failed，error message is：{}", e.getMessage(), e);
        } finally {
            if (null != session) {
                session.closeOnFlush();
            }
        }
    }
}
