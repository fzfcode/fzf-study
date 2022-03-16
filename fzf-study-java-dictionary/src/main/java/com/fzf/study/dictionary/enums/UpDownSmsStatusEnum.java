package com.fzf.study.dictionary.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送状态
 */
public enum UpDownSmsStatusEnum {
    SEND_DOWN("0","发送下行短信"),
    SEND_UP_AND_INSTALMENT_SUCCESS("1","上行且办理分期成功"),
    SEND_UP_BUT_INSTALMENT_FAIL("2","上行但办理分期失败");

    /**
     * 发送状态
     */
    private String sendStatus;
    /**
     * 发送状态描述
     */
    private String sendStatusDesc;

    UpDownSmsStatusEnum(String sendStatus, String sendStatusDesc) {
        this.sendStatus = sendStatus;
        this.sendStatusDesc = sendStatusDesc;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public String getSendStatusDesc() {
        return sendStatusDesc;
    }

    public static final Map<String, UpDownSmsStatusEnum> MAP = new HashMap<>();

    static {
        for (UpDownSmsStatusEnum type : values()) {
            MAP.put(type.getSendStatus(), type);
        }
    }

    public static UpDownSmsStatusEnum getEnum(String value) {
        return MAP.get(value);
    }
}
