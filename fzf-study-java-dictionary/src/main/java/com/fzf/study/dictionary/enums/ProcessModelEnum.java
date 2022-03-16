package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/13
 * @Version:
 * @Description:
 */


public enum  ProcessModelEnum {

    ONLINE(1, "ONLINE","实时处理"),
    BATCH(2, "BATCH","批量处理")
    ;


    @Getter
    private int code;

    @Getter
    private String value;

    @Getter
    private String description;

    ProcessModelEnum(int code,String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static final Map<String, ProcessModelEnum> MAP = new HashMap<>();

    static {
        for (ProcessModelEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static ProcessModelEnum getEnum(String value) {
        return MAP.get(value);
    }
}
