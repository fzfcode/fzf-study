/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020/9/12 18:20
 * @description: 邀请办卡申请状态
 * @version: v1.0
 */
@Getter
public enum CardInvitationStatusEnum {

    /**
     * 三要素提交
     */
    MAIN_INFO_COMMIT("0000", "0", "三要素提交"),

    /**
     * 补充信息提交
     */
    EXT_INFO_COMMIT("1000", "1", "补充信息提交"),

    /**
     * 征审通过
     */
    APS_ACCEPTED("1001", "2", "征审通过"),

    /**
     * 征审未通过
     */
    APS_REJECTED("1002", "3", "征审未通过"),

    /**
     * 卡片激活
     */
    CARD_ACTIVATED("2001", "00", "卡片激活"),

    /**
     * 废件
     */
    APS_DISCARD("4444", "4", "废件");

    private String code;
    private String messageType;
    private String desc;

    CardInvitationStatusEnum(String code, String messageType, String desc) {
        this.code = code;
        this.messageType = messageType;
        this.desc = desc;
    }

    public static final Map<String, CardInvitationStatusEnum> MAPTYPE = new HashMap<>();

    public static final Map<String, CardInvitationStatusEnum> MAPCODE = new HashMap<>();

    static {
        for (CardInvitationStatusEnum type : values()) {
            MAPTYPE.put(type.getMessageType(), type);
            MAPCODE.put(type.getCode(), type);
        }
    }

    public static CardInvitationStatusEnum getCardStatusByMessageType(String value) {
        return MAPTYPE.get(value);
    }

    public static CardInvitationStatusEnum getCardStatusByCode(String value) {
        return MAPCODE.get(value);
    }

}
