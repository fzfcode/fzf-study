package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/3 8:57 下午
 * @description: 活动规则枚举
 */
public enum ActivityActionTypeEnum {

    /**
     * 分期折扣规则
     */
    INSTALMENT_DISCOUNT_RULE("instalmentPreferentialRule", "分期优惠规则"),

    /**
     * 圈人活动短信规则
     */
    CROWD_SMS_RULE("crowdSmsRule", "圈人活动短信规则"),

    /**
     * 账单分期分期期数规则
     */
    STMT_INSTALMENT_RULE("stmtInstalmentRule", "账单分期分期期数规则"),

    /**
     * 账单分期账单有效天数
     */
    STMT_INSTALMENT_VALID_DAY_RULE("stmtInstalmentValidDayRule", "账单分期账单有效天数"),
    ;

    public static final Map<String, ActivityActionTypeEnum> MAP = new HashMap<>();

    static {
        for (ActivityActionTypeEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    @Getter
    private String value;

    @Getter
    private String description;

    ActivityActionTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static ActivityActionTypeEnum getEnum(String value) {
        return MAP.get(value);
    }
}
