package com.fzf.study.rpc.adapter.socket.filter;


import com.fzf.study.rpc.adapter.socket.constant.Constants;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import com.fzf.study.rpc.adapter.socket.util.CodeMarkUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.nio.ByteBuffer;

public class XmlDecoderFilter implements DecodeFilter {


    private static final Logger LOGGER = LoggerFactory.getLogger(XmlDecoderFilter.class);

    private int lengthSize = 4;


    private String charset;

    @Resource
    private CodeMarkUtils codeMarkUtils;


    public int getLengthSize() {
        return lengthSize;
    }

    public void setLengthSize(int lengthSize) {
        this.lengthSize = lengthSize;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    public boolean doDecode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgdef, ProtocolDecoderOutput out) throws Exception {
        return true;
    }

    @Override
    public boolean doDecode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgHeaddef, MessageDefinition msgdef, ProtocolDecoderOutput out, int txnMode) throws Exception {

        if (txnMode == Constants.TXN_MODE_XML) {
            byte[] received = message.getRawMessage();
            int xmlLength = received.length - buffer.position();
            ByteBuffer bodyBuff = ByteBuffer.allocate(xmlLength);
            bodyBuff.put(received, buffer.position(), xmlLength);
            String bodyStr = new String(bodyBuff.array(), StringUtils.isNotBlank(charset) ? charset : Constants.CHARSET_NAME_UTF8);
            message.getCustomAttributes().put(Constants.MESSAGE_KEY, bodyStr);
            buffer.position(received.length);
            LOGGER.debug("接收的xml报文[" + codeMarkUtils.makeMask(bodyStr) + "]");
        }
        return true;
    }
}
