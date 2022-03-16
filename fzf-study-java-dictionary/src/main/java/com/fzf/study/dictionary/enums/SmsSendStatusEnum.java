package com.fzf.study.dictionary.enums;

/**
 * 短信发送状态
 */
public enum SmsSendStatusEnum {
    /**
     * 发送初始化
     */
    SEND_INIT("0","发送初始化"),
    /**
     * 发送成功
     */
    SEND_SUCCESS("1","发送成功"),
    /**
     * 发送失败
     */
    SEND_FAIL("2","发送失败");

    /**
     * 发送状态
     */
    private String sendStatus;
    /**
     * 发送状态描述
     */
    private String sendStatusDesc;

    SmsSendStatusEnum(String sendStatus, String sendStatusDesc) {
        this.sendStatus = sendStatus;
        this.sendStatusDesc = sendStatusDesc;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public String getSendStatusDesc() {
        return sendStatusDesc;
    }
}
