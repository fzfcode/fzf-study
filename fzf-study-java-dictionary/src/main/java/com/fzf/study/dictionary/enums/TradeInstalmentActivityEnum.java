package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public enum TradeInstalmentActivityEnum {

    /**
     * 卡片范围限制规则
     */
    CARD_LIMIT_RULE("cardLimitRule", "卡片范围限制规则"),

    /**
     * 分期场景限制规则
     */
    INSTALMENT_APPLY_PARAM_LIMIT("instalmentApplyParamLimit", "分期场景限制规则"),

    /**
     * 白名单列表
     */
    WHITE_LIST("whitelist","白名单列表"),

    /**
     * 消费分期临界金额
     */
    CONSUME_LOAN_CRITICAL_AMT("cosumeLoanCriticalAmt","消费分期临界金额"),

    LOAN_RULE("loanRule","分期规则"),

    INSTALMENT_CONTROL("instalmentControl","分期管控"),

    LOAN_DISCOUNT_RATE("loanDiscountRate","消费分期差异化利率"),

    CONSUME_LOAN_ACTIVITY_ID("1","消费分期活动Id"),

    INSTALMENT_CONTROL_LOCK("1","分期管控开关,默认1为打开"),

    INSTALMENT_LOAN_DELIMIT("-","消费分期期数分割符"),

    FIRST_MARKETING_TALK("firstLoanMarketing","首次消费分期"),

    FIRST_LOAN_FLAG("Y","首次分期标识"),

    NOT_FIRST_LOAN_FLAG("N","非首次分期标识"),

    LOAN_DISCOUNT_RATE_LOCK("Y","消费分期差异化利率开关"),

    FIRST_LOAN_BEGIN_DATE("beginDate","首次分期营销内容生效日期"),

    FIRST_LOAN_END_DATE("endDate","首次分期营销内容失效日期"),

    FIRST_LOAN_MARKETING_CONTENT("firstLoanMarketingInfo","首次分期营销内容"),

    SEND_SMS_TYPE("marketingSms","营销短信"),

    INDIVIDUAL_MARKETING_SMS_BANK("000064500000","青岛银行营销短信单独发送"),

    CPS_AUTH_SEND_SMS("N","核心是否发送动账短信")

    ;

    public static final Map<String, TradeInstalmentActivityEnum> MAP = new HashMap<>();

    static {
        for (TradeInstalmentActivityEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    @Getter
    private String value;

    @Getter
    private String description;

    TradeInstalmentActivityEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static TradeInstalmentActivityEnum getEnum(String value) {
        return MAP.get(value);
    }
}
