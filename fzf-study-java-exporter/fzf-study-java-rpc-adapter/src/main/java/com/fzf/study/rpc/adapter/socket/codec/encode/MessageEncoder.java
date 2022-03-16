package com.fzf.study.rpc.adapter.socket.codec.encode;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.chain.EncodeFilterChain;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.LengthType;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.CodeMarkUtils;
import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 编码器
 */
@Data
public class MessageEncoder extends ProtocolEncoderAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageEncoder.class);

    private EncodeFilterChain filterChain;

    private LengthType lengthType = LengthType.INT;

    private int lengthSize = 4;

    private int lengthSuffix = 0;

    @Resource
    private CodeMarkUtils codeMarkUtils;


    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

        CoreMessage msg = (CoreMessage) message;

        //通过编码过滤器得到编码结果
        IoBuffer buffer = IoBuffer.allocate(2048, false);
        buffer.setAutoExpand(true);
        buffer.flip();

        //执行编码过滤器链
        buffer = filterChain.doEncodeFilterChain(session, buffer, msg, out);

        if (buffer != null) {

            //读取解码结果，存入消息对象
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            msg.setRawMessage(bytes);

            //重置缓冲区，包装报文内内容放入缓冲
            buffer.clear();

            //组长度
            buffer.put(lengthType.getBytesByLength(lengthSize, bytes.length));

            //如果长度有后缀组后缀
            if (0 != lengthSuffix) {
                buffer.put(new byte[lengthSuffix]);
            }

            //组报文
            buffer.put(bytes);

            //缓冲区写入完毕，为读取做准备

            buffer.flip();

            if (LOGGER.isDebugEnabled()) {
                byte[] log = new byte[buffer.limit()];
                buffer.get(log);
                buffer.rewind();
                LOGGER.debug("发送报文[" + codeMarkUtils.makeMask(new String(Hex.encodeHex(log))));
            }

            out.write(buffer);
        }


    }
}
