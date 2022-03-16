package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典类型
 */
public enum DictTypeEnum {
    /**
     * 账户信息
     */
    ACCT_BASE_INFO("ACCT_BASE_INFO"),
    /**
     * 卡片信息
     */
    CARD_BASE_INFO("CARD_BASE_INFO"),
    /**
     * 卡片介质信息
     */
    CARD_MEDIA_INFO("CARD_MEDIA_INFO"),
    /**
     * 客户信息
     */
    CUST_BASE_INFO("CUST_BASE_INFO"),
    /**
     * 客户地址信息
     */
    CUST_ADDRESS_INFO("CUST_ADDRESS_INFO"),
    /**
     * 分期折扣活动全局配置
     */
    INSTALMENT_DISCOUNT_CONFIG("INSTALMENT_DISCOUNT_CONFIG"),
    /**
     * 系统配置信息
     */
    SYSTEM_CONFIG_INFO("SYSTEM_CONFIG_INFO"),
    /**
     * 分流配置
     */
    ROUTE_CONFIG("ROUTE_CONFIG"),
    /**
     * 发送短信配置
     */
    SMS_SEND_CONFIG("SMS_SEND_CONFIG"),
    /**
     * 圈人活动全局配置
     */
    CUSTOMER_CROWD_CONFIG("CUSTOMER_CROWD_CONFIG"),
    ;

    private String value;

    private static final Map<String, DictTypeEnum> MAP = new HashMap<>(128);

    static {
        for (DictTypeEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static DictTypeEnum getEnum(Integer value) {
        return MAP.get(value);
    }

    public String getValue() {
        return value;
    }

    DictTypeEnum(String value) {
        this.value = value;
    }
}
