package com.fzf.study.dictionary.enums;

public enum SmsTypeEnum {
    STANDARD_SMS_SUFFIX(1,"标准动账短信后缀"),
    MARKETING_SMSM_SUFFIX(2,"营销短信后缀"),
    RIGHT_REPLY_BUT_EXCEED_DEADLINE(3,"消费交易出账单后不支持进行消费交易分期"),
    NMD_ACTIVE_CONFIRM(8,"诺曼底激活预约成功确认短信"),
    REPAY_DRAW_NOTICE(21,"还款抽奖返现通知"),
    ACTIVITY_DOWN_TEMPLATE(31,"营销活动下行短信模板"),
    ACTIVITY_UP_SUCC_TEMPLATE(32,"营销活动上行报名成功短信模板"),
    ACTIVITY_UP_FAILED_TEMPLATE_1(33,"营销活动上行失败1短信模板"),
    ACTIVITY_UP_FAILED_TEMPLATE_2(34,"营销活动上行失败2短信模板"),
    MARKETING_DISCOUNT_SMS_SUFFIX(35,"消费分期营销手续费折扣短信后缀"),
    BALANCE_INSTALMENT_FIRST_INVITE_NO_ACTIVITY_TEMPLATE(450,"一键分期无活动首次下行短信模版"),
    BALANCE_INSTALMENT_FIRST_INVITE_WITH_ACTIVITY_TEMPLATE(451,"一键分期有活动首次下行短信模版"),
    BALANCE_INSTALMENT_SECOND_INVITE_NO_ACTIVITY_TEMPLATE(452," 一键分期无活动再次下行短信模版"),
    BALANCE_INSTALMENT_SECOND_INVITE_WITH_ACTIVITY_TEMPLATE(453," 一键分期有活动再次下行短信模版"),
    BALANCE_INSTALMENT_FAIL_TEMPLATE(454," 一键分期上行分期失败短信模版"),

    STATEMENT_INSTALMENT_DOWN_TEMPLATE(205,"账单分期每期手续费下行短信模板"),
    STATEMENT_INSTALMENT_SUCCESS_TEMPLATE(206,"账单分期上行分期成功短信模版"),
    STATEMENT_INSTALMENT_FAIL_TEMPLATE(207,"账单分期上行分期失败短信模版"),
    STATEMENT_INSTALMENT_DOWN_DISCOUNT_TEMPLATE(208,"账单分期每期手续费下行折扣短信模板"),

    STATEMENT_INSTALMENT_DOWN_SINGLE_TEMPLATE(209,"账单分期一次性收取手续费下行短信模板"),
    STATEMENT_INSTALMENT_DOWN_SINGLE_DISCOUNT_TEMPLATE(210,"账单分期一次性收取手续费下行折扣短信模板"),



    CUSTOMER_CROWD_REPLAY_FAILED_TEMPLATE(482,"圈人活动短信报名回复失败模板"),
    CUSTOMER_CROWD_NOT_WHITE_FAILED_TEMPLATE(483,"圈人活动短信报名用户未在白名单模板"),
    ;


    private int smsId;
    private String templateName;

    public int getSmsId() {
        return smsId;
    }

    public void setSmsId(int smsId) {
        this.smsId = smsId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    SmsTypeEnum(int smsId, String templateName) {
        this.smsId = smsId;
        this.templateName = templateName;
    }
}
