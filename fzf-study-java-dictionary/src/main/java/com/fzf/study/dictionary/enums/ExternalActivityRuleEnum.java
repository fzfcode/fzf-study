package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 5:41 下午
 * @description: 外部活动规则
 */
public enum ExternalActivityRuleEnum {
    CREDIT_LIMIT_CODE_RULE("信用额度区间映射规则", "creditLimitCodeRule"),
    INSTALMENT_TERM_MATCH_RULE("可分期期数匹配规则", "instalmentTermMatch"),
    SMS_REPLY_VALIDITY("短信回复有效期","SMSReplyValidityLimit"),
    MIN_INSTALMENT_AMT("最低可分期金额","minInstalmentAmtLimit");

    @Getter
    private String ruleDesc;

    @Getter
    private String ruleValue;

    ExternalActivityRuleEnum(String ruleDesc, String ruleValue) {
        this.ruleDesc = ruleDesc;
        this.ruleValue = ruleValue;
    }
}
