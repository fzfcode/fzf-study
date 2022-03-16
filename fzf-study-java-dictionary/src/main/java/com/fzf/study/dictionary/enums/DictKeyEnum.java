package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典类型
 */
public enum DictKeyEnum {
    /**
     * 可选的分期类型
     */
    AVAILABLE_INSTALMENT_TYPES("AVAILABLE_INSTALMENT_TYPES"),
    /**
     * 可选的优先级
     */
    AVAILABLE_ACTIVITY_PRIORITY("AVAILABLE_ACTIVITY_PRIORITY"),
    /**
     * 可选的渠道
     */
    AVAILABLE_INSTALMENT_CHANNELS("AVAILABLE_INSTALMENT_CHANNELS"),
    /**
     * 是否支持渠道配置
     */
    HAS_SUPPORT_CHANNEL("HAS_SUPPORT_CHANNEL"),
    /**
     * 可选的卡产品
     */
    AVAILABLE_PRODUCT_CODES("AVAILABLE_PRODUCT_CODES"),
    /**
     * 是否支持客户号白名单配置
     */
    HAS_SUPPORT_CUST_NO_WHITE_LIST("HAS_SUPPORT_CUST_NO_WHITE_LIST"),
    /**
     * 是否支持帐户号白名单配置
     */
    HAS_SUPPORT_ACCT_NO_WHITE_LIST("HAS_SUPPORT_ACCT_NO_WHITE_LIST"),
    /**
     * 是否支持对白名单操作配置
     */
    HAS_SUPPORT_OPERATE_WHITE_LIST("HAS_SUPPORT_OPERATE_WHITE_LIST"),
    /**
     * 分期申请结果分流比例控制
     */
    INSTALMENT_APPLY_RESULT("INSTALMENT_APPLY_RESULT"),
    /**
     * 是否使用营销短信通道
     */
    MARKETING_SMS_CHANNEL("MARKETING_SMS_CHANNEL"),
    /**
     * 短信发送锁定码控制
     */
    SMS_BLOCKCODE_CONTROL("SMS_BLOCKCODE_CONTROL"),
    /**
     * 可选的报名ID类型
     */
    AVAILABLE_SIGNUP_MEMBER_TYPES("AVAILABLE_SIGNUP_MEMBER_TYPES"),
    /**
     * 可选的报名渠道
     */
    AVAILABLE_SIGNUP_CHANNEL("AVAILABLE_SIGNUP_CHANNEL"),

    /**
     * 下行报名活动短信后缀
     */
    SMS_SEND_TEMPLATE_SUFFIX("SMS_SEND_TEMPLATE_SUFFIX"),

    /**
     * 圈人活动短信MQ上行开关
     */
    CUSTOMER_CROWD_SMS_UP_MQ_SWITCH("CUSTOMER_CROWD_SMS_UP_MQ_SWITCH"),

    /**
     * 账单分期下行短信发送开关
     */
    STATEMENT_INSTALMENT_INVITE_MSG_SEND("STATEMENT_INSTALMENT_INVITE_MSG_SEND"),

    /**
     * 账单分期下行短信记录生成开关
     */
    STATEMENT_INSTALMENT_SMS_GENERATE_SWITCH("STATEMENT_INSTALMENT_SMS_GENERATE_SWITCH"),

    /**
     * 账单分期短信发送开关
     */
    STATEMENT_INSTALMENT_SMS_SEND_SWITCH("STATEMENT_INSTALMENT_SMS_SEND_SWITCH"),

	/**
	 * 切流到触达系统的规则名称列表
	 */
	SMS_ROUTE_OCTOPUS_RULE_NAME_LIST("SMS_ROUTE_OCTOPUS_RULE_NAME_LIST"),

	/**
	 * 卡账客数据同步批量开关
	 */
	DATA_SYNCHRONIZATION_BATCH_SWITCH("DATA_SYNCHRONIZATION_BATCH_SWITCH"),

	/**
	 * 青岛个性化费率数据导入批量开关
	 */
	INSTALMENT_DISCOUNT_BATCH_SWITCH("INSTALMENT_DISCOUNT_BATCH_SWITCH"),
    ;

    private String value;

    private static final Map<String, DictKeyEnum> MAP = new HashMap<>(256);

    static {
        for (DictKeyEnum type : values()) {
            MAP.put(type.getValue(), type);
        }
    }

    public static DictKeyEnum getEnum(Integer value) {
        return MAP.get(value);
    }

    public String getValue() {
        return value;
    }

    DictKeyEnum(String value) {
        this.value = value;
    }
}
