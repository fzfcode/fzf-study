package com.fzf.study.rpc.adapter.socket.filter;


import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public interface DecodeFilter {


    boolean doDecode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgdef, ProtocolDecoderOutput out) throws Exception;


    boolean doDecode(IoSession session, IoBuffer buffer, CoreMessage message, MessageDefinition msgHeaddef, MessageDefinition msgdef, ProtocolDecoderOutput out, int txnMode) throws Exception;

}
