package com.fzf.study.rpc.adapter.socket.chain;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.filter.EncodeFilter;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.MessageDefinition;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class UnifiedEncodeFilterChain extends EncodeFilterChain {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnifiedEncodeFilterChain.class);

    private int txnMode;

    private MessageDefinition msgHeadDef;

    public int getTxnMode() {
        return txnMode;
    }

    public void setTxnMode(int txnMode) {
        this.txnMode = txnMode;
    }

    public MessageDefinition getMsgHeadDef() {
        return msgHeadDef;
    }

    public void setMsgHeadDef(MessageDefinition msgHeadDef) {
        this.msgHeadDef = msgHeadDef;
    }

    public IoBuffer doEncodeFilterChain(IoSession session, IoBuffer buffer, CoreMessage message, ProtocolEncoderOutput out) throws Exception {

        Iterator<EncodeFilter> iterator = chain.iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().doEncode(session, buffer, message, msgHeadDef, messageDefinition, out, txnMode))
                break;
        }
        return buffer;
    }


}
