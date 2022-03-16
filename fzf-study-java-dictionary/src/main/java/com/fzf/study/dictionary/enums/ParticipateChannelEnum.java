package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动参与渠道枚举
 * @author sunke04
 */
public enum ParticipateChannelEnum {
    /**
     * 分期申请
     */
    INSTALMENT_APPLY("INSTALMENT_APPLY"),
    ;

    private String value;

    private static final Map<String, ParticipateChannelEnum> MAP = new HashMap<>(128);

    static {
        for (ParticipateChannelEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static ParticipateChannelEnum getEnum(String value) {
        return MAP.get(value);
    }

    public String getValue() {
        return value;
    }

    ParticipateChannelEnum(String value) {
        this.value = value;
    }
}
