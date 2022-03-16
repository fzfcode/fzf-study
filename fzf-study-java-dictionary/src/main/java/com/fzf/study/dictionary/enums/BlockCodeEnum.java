/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.enums;

/**
 * @author: zhujianxun
 * @date: 2020/9/29 11:19 上午
 * @description: 锁定码Enum
 */
public enum BlockCodeEnum {
    /**
     * 销卡销户
     */
    C_CODE("C", "销卡销户"),
    /**
     * 丢失
     */
    R_CODE("R", "丢失"),
    /**
     * 被盗
     */
    S_CODE("S", "被盗"),
    /**
     * 客户进线否认相关交易
     */
    N_CODE("N", "客户进线否认相关交易"),
    ;

    private String value;
    private String label;

    BlockCodeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
