package com.fzf.study.dictionary.enums;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 4:51 下午
 * @description: 短信回复码枚举
 */
public enum SmsReplyCodeEnum {
    /**
     * 诺曼底邀请激活短信
     */
    YJ("诺曼底邀请激活短信", "YJ"),

    /**
     * 一键分期上行短信回复标识
     */
    QFQ("一键分期上行短信", "QFQ"),

    /**
     * 消费分期行短信回复码
     */
    JYFQ("消费分期行短信回复码", "JYFQ"),

    /**
    * 账单分期上行短信回复码
     */
    FQ("账单分期上行短信回复码", "FQ"),

    /**
     * 账单分期上行短信回复码-营销专用
     */
    BFQ("账单分期上行短信回复码", "BFQ"),
    ;

    private String desc;
    private String value;

    SmsReplyCodeEnum(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

    public static SmsReplyCodeEnum getSearchSmsReplyCode(String value) {
        for (SmsReplyCodeEnum type : SmsReplyCodeEnum.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }


    public String getValue() {
        return value;
    }

}
