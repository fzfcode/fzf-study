package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动参与状态
 */
public enum ActivityParticipateStatusEnum {
    /**
     * 已冻结
     */
    FROZEN(0),

    /**
     * 已确认
     */
    CONFIRMED(1),

    /**
     * 已取消
     */
    CANCELED(2),
    ;

    private static final Map<Integer, ActivityParticipateStatusEnum> MAP = new HashMap<>(16);

    static {
        for (ActivityParticipateStatusEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static ActivityParticipateStatusEnum getEnum(Integer value) {
        return MAP.get(value);
    }

    private int value;

    public int getValue() {
        return value;
    }

    ActivityParticipateStatusEnum(int value) {
        this.value = value;
    }
}
