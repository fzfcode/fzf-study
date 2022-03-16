package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/3 8:57 下午
 * @description: 活动扩展信息类型枚举
 */
public enum ActivityExtTypeEnum {

    /**
     * 优先级
     */
    PRIORITY_LEVEL("PRIORITY_LEVEL"),

    /**
     * 最近修改人
     */
    LATEST_UPDATE_USER("LATEST_UPDATE_USER"),

    /**
     * 报名号类型
     */
    SIGN_UP_MEMBER_TYPE("SIGN_UP_MEMBER_TYPE"),

    /**
     * 报名截止时间
     */
    SIGN_UP_DEAD_TIME("SIGN_UP_DEAD_TIME"),

    ;

    public static final Map<String, ActivityExtTypeEnum> MAP = new HashMap<>();

    static {
        for (ActivityExtTypeEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    @Getter
    private String value;

    ActivityExtTypeEnum(String value) {
        this.value = value;
    }

    public static ActivityExtTypeEnum getEnum(String value) {
        return MAP.get(value);
    }
}
