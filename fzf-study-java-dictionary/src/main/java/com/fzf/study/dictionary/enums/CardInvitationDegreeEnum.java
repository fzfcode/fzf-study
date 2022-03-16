/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020/9/12 18:35
 * @description: 邀请卡片新旧户标识
 * @version: v1.0
 */
@Getter
public enum CardInvitationDegreeEnum {

    /**
     * 新户
     */
    NEW("1", "新户"),

    /**
     * 旧户
     */
    OLD("2", "旧户"),

    /**
     * 疑似旧户
     */
    SUSPECTEDOLD("3", "疑似旧户");

    private String code;
    private String desc;

    CardInvitationDegreeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static final Map<String, CardInvitationDegreeEnum> MAP = new HashMap<>();

    static {
        for (CardInvitationDegreeEnum type : values()) {
            MAP.put(type.getCode(), type);
        }
    }

    public static CardInvitationDegreeEnum getSearchOptByCode(String value) {
        return MAP.get(value);
    }
}
