package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/3 8:57 下午
 * @description: 活动类型枚举
 */
public enum ActivityTypeEnum {

    /**
     * 短信邀请账单分期
     */
    STATEMENT_INSTALMENT_SMS_INVITE(4),

    /**
     * 还款抽奖返现
     */
    REPAY_DRAW(10),

    /**
     * 分期折扣
     */
    INSTALMENT_DISCOUNT(11),

    /**
     * 短信邀请余额分期
     */
    BALANCE_INSTALMENT_SMS_INVITE(12),

    /**
     * 账单分期
     */
    STMT_INSTALMENT(13),

    /**
     * 诺曼底短信
     */
    NORMANDY_SMS(14),

    /**
     * 圈人活动
     */
    CUSTOMER_CROWD(15),
    ;

    public static final Map<Integer, ActivityTypeEnum> MAP = new HashMap<>();

    static {
        for (ActivityTypeEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    @Getter
    private int value;

    ActivityTypeEnum(int value) {
        this.value = value;
    }

    public static ActivityTypeEnum getEnum(Integer value) {
        return MAP.get(value);
    }
}
