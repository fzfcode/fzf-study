package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/15
 * @Version:
 * @Description:
 */


public enum  SmsCodeEnum {
    BALANCE_INSTALMENT_SMS_CD("Balance_Instalment", "余额分期邀请短信代码"),
    BALANCE_INSTALMENT_SMS_FAIL("Balance_Fail", "余额分期办理失败短信代码"),
    STATEMENT_INSTALMENT_SMS_FAIL("Statement_Fail", "账单分期办理失败短信代码"),
    STATEMENT_INSTALMENT_SMS_SUCCESS("Statement_Success", "账单分期办理成功短信代码"),
    STATEMENT_INSTALMENT_SMS_INVITE_CD("Statement_Invite", "账单分期邀请短信代码"),
    ;

    @Getter
    private String value;

    @Getter
    private String description;

    SmsCodeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
