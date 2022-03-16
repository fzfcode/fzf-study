package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * BMP短信类模板类别
 */
@Getter
public enum BmpSmsParamEnum {
    DOMESTIC_SMS_CATEGORY("本币动账短信分类","CPS023"),
    FOREIGN_SMS_CATEGORY("外币动账短信分类","CPS111"),
    LOAN_FAIL_SMS_CATEGORY("分期失败短信类别","CPS312"),
    ;

    private String name;

    private String value;

    BmpSmsParamEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static final Map<String, BmpSmsParamEnum> MAP = new HashMap<>();

    static {
        for (BmpSmsParamEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static BmpSmsParamEnum getEnum(String value) {
        return MAP.get(value);
    }
}
