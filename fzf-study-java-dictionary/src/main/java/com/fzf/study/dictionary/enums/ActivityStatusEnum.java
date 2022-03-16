package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/3 8:57 下午
 * @description: 活动状态枚举
 */
public enum ActivityStatusEnum {


    /**
     * 有效
     */
    VALID(1),

    /**
     * 已失效
     */
    INVALID(0),

    /**
     * 暂停
     */
    PAUSE(2),
    ;

    public static final Map<Integer, ActivityStatusEnum> MAP = new HashMap<>();

    static {
        for (ActivityStatusEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    @Getter
    private int value;

    ActivityStatusEnum(int value) {
        this.value = value;
    }

    public static ActivityStatusEnum getEnum(Integer value) {
        return MAP.get(value);
    }
}
