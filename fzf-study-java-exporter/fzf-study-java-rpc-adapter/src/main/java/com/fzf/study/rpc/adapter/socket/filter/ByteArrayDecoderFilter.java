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
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.ByteBuffer;

/**
 * 字节解码过滤
 * @author mudaoming
 */
public class ByteArrayDecoderFilter implements DecodeFilter {

    private static final Logger log = LoggerFactory.getLogger(ByteArrayDecoderFilter.class);

    private String charset;

    private int lengthSize = 4;

    @Autowired
    private CodeMarkUtils codeMarkUtils;

    public int getLengthSize() {
        return lengthSize;
    }

    public void setLengthSize(int lengthSize) {
        this.lengthSize = lengthSize;
    }

    @Override
    public boolean doDecode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgdef, ProtocolDecoderOutput out) throws Exception {
        buffer.position(buffer.position() + message.getRawMessage().length);
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

            log.debug("接收的xml报文[" + codeMarkUtils.makeMask(bodyStr) + "]");

        }
        return true;
    }
}
