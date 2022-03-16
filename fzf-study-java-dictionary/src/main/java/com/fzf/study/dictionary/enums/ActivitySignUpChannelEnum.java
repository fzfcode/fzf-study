package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020-10-16 16:39:20
 * @description: 活动报名渠道Enum
 * @version: v1.0
 */
@Getter
public enum ActivitySignUpChannelEnum {

    /**
     * 短信报名渠道
     */
    SMS(1, "SMS", "短信"),

    /**
     * 小程序报名渠道
     */
    MINI_PROGRAM(2, "MiniProgram", "小程序"),

    ;

    private Integer codeNo;
    private String codeValue;
    private String desc;

    ActivitySignUpChannelEnum(Integer codeNo, String codeValue, String desc) {
        this.codeNo = codeNo;
        this.codeValue = codeValue;
        this.desc = desc;
    }

    public static final Map<String, ActivitySignUpChannelEnum> MAP_VALUE = new HashMap<>();

    public static final Map<Integer, ActivitySignUpChannelEnum> MAP_NO = new HashMap<>();

    static {
        for (ActivitySignUpChannelEnum type : values()) {
            MAP_VALUE.put(type.getCodeValue(), type);
            MAP_NO.put(type.getCodeNo(), type);
        }
    }

    public static ActivitySignUpChannelEnum getChannelEumByValue(String value) {
        return MAP_VALUE.get(value);
    }

    public static ActivitySignUpChannelEnum getChannelEumByNo(Integer value) {
        return MAP_NO.get(value);
    }

}
