package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 分期申请结果枚举
 * @author sunke04
 */
public enum InstalmentApplyResultEnum {
    /**
     * 成功
     */
    SUCCESS(1),
    /**
     * 失败
     */
    FAILED(0),

    ;

    private int value;

    private static final Map<Integer, InstalmentApplyResultEnum> MAP = new HashMap<>(128);

    static {
        for (InstalmentApplyResultEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static InstalmentApplyResultEnum getEnum(Integer value) {
        return MAP.get(value);
    }

    public int getValue() {
        return value;
    }

    InstalmentApplyResultEnum(int value) {
        this.value = value;
    }
}
