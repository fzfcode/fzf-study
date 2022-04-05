package com.fzf.study.rpc.adapter.socket.chain;


import com.fzf.study.rpc.adapter.socket.filter.EncodeFilter;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EncodeFilterChain {


    public LinkedList<EncodeFilter> chain = new LinkedList<>();

    public MessageDefinition messageDefinition;

    public void setChain(List<EncodeFilter> chain) {
        this.chain = new LinkedList<>(chain);
    }

    public void add(EncodeFilter encodeFilter) {
        chain.add(encodeFilter);
    }

    public MessageDefinition getMessageDefinition() {
        return messageDefinition;
    }

    public void setMessageDefinition(MessageDefinition messageDefinition) {
        this.messageDefinition = messageDefinition;
    }


    public IoBuffer doEncodeFilterChain(IoSession session, IoBuffer buffer, CoreMessage message, ProtocolEncoderOutput out) throws Exception {

        Iterator<EncodeFilter> iterator = chain.iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().doEncode(session, buffer, message, messageDefinition, out))
                break;
        }
        return buffer;
    }
}
