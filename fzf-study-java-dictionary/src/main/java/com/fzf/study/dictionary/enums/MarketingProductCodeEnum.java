package com.fzf.study.dictionary.enums;

/**
 * @Description：营销产品代码枚举
 * @Author：shifei
 * @Date：2021/9/13 4:12 下午
 */
public enum MarketingProductCodeEnum{
    POINT("POINT", "积分"),

    INSTALMENT_DISCOUNT_COUPON("INSTALMENT_DISCOUNT_COUPON", "分期折扣券"),

    INSTALMENT_DISCOUNT_ACTIVITY("INSTALMENT_DISCOUNT_ACTIVITY", "分期折扣活动券"),

    INSTALMENT_DISCOUNT_RATE_COUPON("INSTALMENT_DISCOUNT_RATE_COUPON", "分期折扣费率券"),

    RED_ENVELOPE("RED_ENVELOPE", "红包")

    ;

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    MarketingProductCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
