package com.fzf.study.rpc.adapter.socket.enums;

import com.fzf.study.rpc.adapter.socket.util.CodecUtil;
import org.springframework.core.codec.CodecException;

public enum LengthType {

    /**
     * bit数字类型
     */

    INT() {
        public int getValueLengthByType(byte[] lengthBytes) throws IllegalArgumentException, CodecException {

            return CodecUtil.byteToInt(lengthBytes);
        }


        public byte[] getBytesByLength(int lengthSize, int value) throws CodecException {

            if (lengthSize != 1 && lengthSize != 2 && lengthSize != 4) {
                throw new CodecException("INT类型的长度容量必须为1，2，4中的一个");
            }

            byte[] bytes = new byte[4];

            bytes[0] = (byte) ((value >>> 24) & 0xff);
            bytes[1] = (byte) ((value >>> 16) & 0xff);
            bytes[2] = (byte) ((value >>> 8) & 0xff);
            bytes[3] = (byte) ((value >>> 0) & 0xff);

            byte[] tempBytes = new byte[lengthSize];

            for (int i = tempBytes.length - 1; i >= 0; i--) {
                tempBytes[i] = bytes[4 - (tempBytes.length - i)];
            }

            return tempBytes;
        }

    },

    STRING() {
        @Override
        public int getValueLengthByType(byte[] lengthBytes) throws IllegalArgumentException {

            return Integer.parseInt(new String(lengthBytes));

        }

        @Override
        public byte[] getBytesByLength(int lengthSize, int value) throws CodecException {
            return String.format("%0" + lengthSize + "d", value).getBytes();
        }
    };

    public abstract int getValueLengthByType(byte[] lengthBytes) throws IllegalArgumentException, CodecException;


    public abstract byte[] getBytesByLength(int lengthSize, int value) throws CodecException;

}
