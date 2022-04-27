package com.fzf.study.rpc.adapter.socket.filter;


import com.fzf.study.rpc.adapter.socket.constant.Constants;
import com.fzf.study.rpc.adapter.socket.enums.LengthType;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import com.fzf.study.rpc.adapter.socket.util.CodecUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.ByteBuffer;

/**
 * 字节编码过滤
 * @author mudaoming
 */
public class ByteArrayEncodeFilter implements EncodeFilter {
    private String charset;


    @Override
    public boolean doEncode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgdef, ProtocolEncoderOutput out) throws Exception {
        CoreMessage CoreMessage = (CoreMessage) message;
        buffer.position(buffer.limit());
        buffer.put(CoreMessage.getRawMessage());
        buffer.flip();
        return true;
    }

    @Override
    public boolean doEncode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgHeaddef, MessageDefinition msgdef, ProtocolEncoderOutput out, int txnMode) throws Exception {
        ByteBuffer temp = null;

        if (txnMode == Constants.TXN_MODE_XML) {

            String mes = (String) message.getCustomAttributes().get(Constants.MESSAGE_KEY);

            temp = CodecUtil.lvBytes(mes.getBytes(StringUtils.isNotBlank(charset)?charset:Constants.CHARSET_NAME_UTF8), LengthType.STRING, 0);

        }

        buffer.position(buffer.limit());
        buffer.put(temp);
        buffer.flip();
        return true;
    }
}
