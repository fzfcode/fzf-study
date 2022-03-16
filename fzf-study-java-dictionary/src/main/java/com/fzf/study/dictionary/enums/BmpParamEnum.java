package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * BMP参数
 */
@Getter
public enum BmpParamEnum {
    PRODUCT_CREDIT("产品类","com.allinfinance.cps.param.def.ProductCredit"),
    ORGANIZATION("机构层参数","com.allinfinance.cps.param.def.Organization"),
    BMP_SMS_TEMPLATE("短信模版类","com.allinfinance.bmp.param.def.BMPMessageTemplate"),
    CURRENCY_CD("币种代码","com.allinfinance.bmp.param.def.CurrencyCd"),
    AccountAttribute("账户属性参数", "com.allinfinance.cps.param.def.AccountAttribute");


    private String name;

    private String value;

    BmpParamEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static final Map<String, BmpParamEnum> MAP = new HashMap<>();

    static {
        for (BmpParamEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static BmpParamEnum getEnum(String value) {
        return MAP.get(value);
    }
}
