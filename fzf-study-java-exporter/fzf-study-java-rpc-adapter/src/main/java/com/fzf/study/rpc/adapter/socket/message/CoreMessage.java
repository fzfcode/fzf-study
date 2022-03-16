package com.fzf.study.rpc.adapter.socket.message;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Data
public class CoreMessage implements Serializable {


    private byte[] rawMessage;

    /**
     * 行内统一报文头，用于行内统一前置用
     */
    private Map<Integer, String> unifiedHeadAttributes = new HashMap<>();

    private Map<String, Serializable> customAttributes = new HashMap<>();

}



