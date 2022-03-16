package com.fzf.study.rpc.adapter.socket.message;


import com.fzf.study.rpc.adapter.socket.enums.LengthType;
import lombok.Data;

@Data
public class MessageDefinition {

    private String encoding;

    private String separator;

    private LengthType lengthType;

}
