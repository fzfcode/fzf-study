package com.fzf.study.rpc.adapter.socket.chain;


import com.fzf.study.rpc.adapter.socket.filter.DecodeFilter;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.message.MessageDefinition;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class UnifiedDecodeFilterChain extends DecoderFilterChain {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnifiedDecodeFilterChain.class);

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

    public CoreMessage doDecodeFilterChain(IoSession session, IoBuffer buffer, CoreMessage message, ProtocolDecoderOutput out) throws Exception {

        LOGGER.info("当前行内统一前置的报文模式txnMode为：{}", txnMode);

        Iterator<DecodeFilter> iterator = chain.iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().doDecode(session, buffer, message, msgHeadDef, messageDefinition, out, txnMode))
                break;
        }

        return message;
    }


}
