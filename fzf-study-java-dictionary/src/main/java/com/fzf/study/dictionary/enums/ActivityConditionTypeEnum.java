package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/3 8:57 下午
 * @description: 活动规则枚举
 */
public enum ActivityConditionTypeEnum {

    /**
     * 卡片范围限制规则
     */
    CARD_LIMIT_RULE("cardLimitRule", "卡片范围限制规则"),

    /**
     * 分期场景限制规则
     */
    INSTALMENT_APPLY_PARAM_LIMIT("instalmentApplyParamLimit", "分期场景限制规则"),

    /**
     * 分期状态限制
     */
    INSTALMENT_STATE_LIMIT("instalmentStateLimit", "分期状态限制"),

    /**
     * 客户范围限制规则
     */
    CUST_LIMIT_RULE("custLimitRule", "客户范围限制规则"),

    /**
     * 帐户范围限制规则
     */
    ACCT_LIMIT_RULE("acctLimitRule", "客户范围限制规则"),

    /**
     * 圈人活动客户范围限制规则
     */
    CROWD_WHITELIST_LIMIT_RULE("crowdWhitelistLimitRule", "圈人活动客户范围限制规则"),

    /**
     * 圈人活动场景限制规则
     */
    CROWD_SIGNUP_PARAM_LIMIT("crowdSignUpParamLimit", "圈人活动场景限制规则"),



    /**
     * 账单分期白名单规则
     */
    STMT_WHITE_LIST("stmtWhiteList", "账单分期白名单规则"),

    /**
     * 账单分期营销日期规则
     */
    STMT_MARKET_DATE("stmtMarketDate", "账单分期营销日期规则"),

    /**
     * 账单分期最低分期金额规则
     */
    STMT_INSTALMENT_LOWEST_AMOUNT("stmtInstalmentLowestAmount", "账单分期最低分期金额规则"),

    /**
     * 短信邀请线程池大小规则
     */
    STMT_INVITE_THREAD_POOL_SIZE("mktStmtInviteThreadPoolSize", "短信邀请线程池大小"),
    ;

    public static final Map<String, ActivityConditionTypeEnum> MAP = new HashMap<>();

    static {
        for (ActivityConditionTypeEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    @Getter
    private String value;

    @Getter
    private String description;

    ActivityConditionTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static ActivityConditionTypeEnum getEnum(String value) {
        return MAP.get(value);
    }
}
