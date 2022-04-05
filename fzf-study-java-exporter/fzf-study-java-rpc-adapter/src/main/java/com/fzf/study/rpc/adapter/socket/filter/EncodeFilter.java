package com.fzf.study.rpc.adapter.socket.filter;


import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public interface EncodeFilter {


    boolean doEncode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgdef, ProtocolEncoderOutput out) throws Exception;

    boolean doEncode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgHeaddef, MessageDefinition msgdef, ProtocolEncoderOutput out, int txnMode) throws Exception;

}
