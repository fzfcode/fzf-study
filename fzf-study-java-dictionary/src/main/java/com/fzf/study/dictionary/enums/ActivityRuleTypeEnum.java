package com.fzf.study.dictionary.enums;

public enum ActivityRuleTypeEnum {
    /**
     * 激活邀请下行短信
     */
    SMS_ACTIVATION_INVITE("激活邀请下行短信","smsActivationInvite", "ONLYONE"),
    /**
     * 笔笔抽下行短信
     */
    SMS_BBS_DAILY_MKT("笔笔抽下行短信","smsBbsDailyMkt", "DAY"),
    /**
     * 超级五折短信
     */
    SMS_SUPER_DISCOUNT("超级五折短信","smsSuperDiscount", "DAY"),
    ;

    private String ruleDesc;
    private String ruleValue;
    private String ruleInterval;

    ActivityRuleTypeEnum(String ruleDesc, String ruleValue, String ruleInterval) {
        this.ruleDesc = ruleDesc;
        this.ruleValue = ruleValue;
        this.ruleInterval = ruleInterval;
    }

    public static ActivityRuleTypeEnum getSearchRuleType(String ruleValue){
        for(ActivityRuleTypeEnum type: ActivityRuleTypeEnum.values()){
            if(type.ruleValue.equals(ruleValue)){
                return type;
            }
        }
        return null;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public String getRuleValue() {
        return ruleValue;
    }

    public String getRuleInterval() {
        return ruleInterval;
    }
}
