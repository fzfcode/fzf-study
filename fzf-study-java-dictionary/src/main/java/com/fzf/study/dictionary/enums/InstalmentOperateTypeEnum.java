package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

public enum InstalmentOperateTypeEnum {
    /**
     * 查询
     */
    QUERY(0),

    /**
     * 试算
     */
    CALCULATE(1),

    /**
     * 冻结
     */
    FREEZE(2),

    ;

    private int value;

    private static final Map<Integer, InstalmentOperateTypeEnum> MAP = new HashMap<>(128);

    static {
        for (InstalmentOperateTypeEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static InstalmentOperateTypeEnum getEnum(Integer value) {
        return MAP.get(value);
    }

    public int getValue() {
        return value;
    }

    InstalmentOperateTypeEnum(int value) {
        this.value = value;
    }
}
