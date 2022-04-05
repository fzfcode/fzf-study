package com.fzf.study.rpc.adapter.socket.codec.decode;

import com.fzf.study.rpc.adapter.socket.chain.DecoderFilterChain;
import com.fzf.study.rpc.adapter.socket.enums.LengthType;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.util.CodeMarkUtils;
import com.fzf.study.rpc.adapter.socket.util.CodecUtil;
import org.slf4j.Logger;
import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Data
public class MessageDecoder extends CumulativeProtocolDecoder {


    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDecoder.class);

    private DecoderFilterChain filterChain;

    private LengthType lengthType = LengthType.INT;

    private int lengthSize = 4;

    private int lengthSuffix = 0;


    @Resource
    private CodeMarkUtils codeMarkUtils;

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {


        in.mark();

        if (in.remaining() < lengthSize + lengthSuffix) {
            return false;
        }

        byte[] lengthBytes = new byte[lengthSize + lengthSuffix];

        in.get(lengthBytes);

        int length;

        boolean dataAvailable;

        switch (lengthType) {

            case INT:

                byte[] visaLengthBytes = new byte[lengthSize];
                for (int i = 0; i < lengthSize; i++) {
                    visaLengthBytes[i] = lengthBytes[i];
                }

                length = CodecUtil.byteToInt(visaLengthBytes);
                break;

            case STRING:
                length = Integer.parseInt(new String(lengthBytes));
                break;
            default:
                throw new IllegalArgumentException("不支持的长度类型[" + lengthType + "]");
        }

        dataAvailable = in.remaining() >= length;

        in.reset();

        if (dataAvailable) {
            if (LOGGER.isDebugEnabled()) {
                byte[] log = new byte[length + lengthSize + lengthSuffix];
                in.get(log);
                in.reset();
                LOGGER.debug("接受的报文[{}]", codeMarkUtils.makeMask(new String(Hex.encodeHex(log))));
            }

            in.get(lengthBytes);
            in.mark();
            byte[] rawMessage = new byte[length];
            in.get(rawMessage);
            CoreMessage message = new CoreMessage();
            message.setRawMessage(rawMessage);

            try {

                IoBuffer buf = IoBuffer.allocate(rawMessage.length, false);
                buf.mark();
                buf.put(rawMessage);
                buf.reset();

                filterChain.doDecodeFilterChain(session, buf, message, out);
                if (buf.hasRemaining()) {
                    throw new Exception("接收的报文格式错误，解析后有剩余数据，此报文做丢弃处理");
                }
                out.write(message);
            } catch (Exception e) {

                LOGGER.error("接收的报文格式错误，此报文做丢弃处理", e);
                return true;
            }
            return true;
        }
        return false;
    }
}
