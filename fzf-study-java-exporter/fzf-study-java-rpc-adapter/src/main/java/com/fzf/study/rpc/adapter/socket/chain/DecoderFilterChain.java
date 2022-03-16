package com.fzf.study.rpc.adapter.socket.chain;


import com.fzf.study.rpc.adapter.socket.filter.DecodeFilter;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DecoderFilterChain {


    public LinkedList<DecodeFilter> chain = new LinkedList<>();

    public MessageDefinition messageDefinition;

    public void setChain(List<DecodeFilter> chain) {
        this.chain = new LinkedList<>(chain);
    }


    public void add(DecodeFilter decodeFilter) {
        chain.add(decodeFilter);
    }


    public MessageDefinition getMessageDefinition() {
        return messageDefinition;
    }

    public void setMessageDefinition(MessageDefinition messageDefinition) {
        this.messageDefinition = messageDefinition;
    }

    public CoreMessage doDecodeFilterChain(IoSession session, IoBuffer buffer, CoreMessage message, ProtocolDecoderOutput out) throws Exception {

        Iterator<DecodeFilter> iterator = chain.iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().doDecode(session, buffer, message, messageDefinition, out))
                break;
        }
        return message;
    }

}
