package com.fzf.study.rpc.adapter.socket.util;



import com.fzf.study.rpc.adapter.socket.enums.LengthType;
import org.springframework.core.codec.CodecException;

import java.nio.ByteBuffer;


public class CodecUtil {


    public static int byteToInt(final byte[] bytes) throws CodecException {

        if (bytes.length != 1 && bytes.length != 2 && bytes.length != 4) {
            throw new CodecException("INT类型的byte数组长度必须为1,2,4中的一个");
        }

        int n = 0;

        for (int i = 0; i < bytes.length; i++) {
            n <<= 8;
            n |= (bytes[i] & 0xff);
        }

        return n;
    }

    public static ByteBuffer lvBytes(final byte[] bytes, final LengthType lengthType, final int lengthSize) throws CodecException {

        if (lengthSize > 0) {
            ByteBuffer buff = ByteBuffer.allocate(lengthSize + bytes.length);
            byte[] length;
            switch (lengthType) {
                case STRING:
                    length = String.format("%0" + lengthSize + "d", bytes.length).getBytes();
                    break;
                case INT:
                    if (lengthSize != 1 && lengthSize != 2 && lengthSize != 4) {
                        throw new CodecException("INT类型的长度容量必须为1，2，4中的一个");
                    }

                    length = new byte[lengthSize];

                    for (int i = 0; i < lengthSize; i++) {
                        length[i] = (byte) (bytes.length >> ((lengthSize - i - 1) * 8));
                    }
                    break;

                default:
                    throw new IllegalArgumentException("不支持的长度类型[" + lengthType + "]");
            }

            buff.put(length);
            buff.put(bytes);
            buff.flip();
            return buff;
        } else {
            return ByteBuffer.wrap(bytes);
        }

    }
}
