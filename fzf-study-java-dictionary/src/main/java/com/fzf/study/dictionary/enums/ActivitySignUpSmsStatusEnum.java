package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2021-03-04 15:08:21
 * @description: 活动报名短信状态Enum
 * @version: v1.0
 */
@Getter
public enum ActivitySignUpSmsStatusEnum {

    /**
     * 未发送
     */
    NOT_SEND(0),

    /**
     * 发送成功
     */
    SUCCEED(1),

    /**
     * 发送失败
     */
    FAIL(2),
    ;

    private Integer code;

    ActivitySignUpSmsStatusEnum(Integer code) {
        this.code = code;
    }


    public static final Map<Integer, ActivitySignUpSmsStatusEnum> MAP = new HashMap<>();

    static {
        for (ActivitySignUpSmsStatusEnum type : values()) {
            MAP.put(type.getCode(), type);
        }
    }

    public static ActivitySignUpSmsStatusEnum getStatus(Integer code) {
        return MAP.get(code);
    }

}
