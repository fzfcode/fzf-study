package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020-10-16 16:39:20
 * @description: 活动报名状态Enum
 * @version: v1.0
 */
@Getter
public enum ActivitySignUpStatusEnum {

    /**
     * 未报名
     */
    NOT_SIGN_UP(0),

    /**
     * 报名成功
     */
    SUCCEED(1),

    /**
     * 报名取消
     */
    CANCELLED(2),

    /**
     * 报名失败
     */
    FAIL(3),
    ;

    private Integer code;

    ActivitySignUpStatusEnum(Integer code) {
        this.code = code;
    }


    public static final Map<Integer, ActivitySignUpStatusEnum> MAP = new HashMap<>();

    static {
        for (ActivitySignUpStatusEnum type : values()) {
            MAP.put(type.getCode(), type);
        }
    }

    public static ActivitySignUpStatusEnum getStatus(Integer code) {
        return MAP.get(code);
    }

}
