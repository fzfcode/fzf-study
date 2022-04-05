/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.exception.error.code;

/**
 * @author: zhujianxun
 * @date: 2020/9/22 5:37 下午
 * @description: 短信发送错误码
 */
public enum SmsSendErrorCodeEnum {
    /**
     * 发送标准动账短信失败
     */
    SEND_STANDAR_SMS_TEMPLATE_FAIL("405", "发送标准动账短信失败"),
    /**
     * 发送动账营销短信失败
     */
    SEND_MARKETING_SMS_TEMPLATE_FAIL("406", "发送动账营销短信失败"),
    /**
     * 调用核心前参数检查异常
     */
    SMS_CHECK_PARAM_FAIL("407", "调用核心前参数检查异常");
    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    SmsSendErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
