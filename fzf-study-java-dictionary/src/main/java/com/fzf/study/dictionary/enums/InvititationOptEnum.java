package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: HouGang
 * @date: 2020-09-15 15:29:33
 * @description: 邀请性质 个人/公司
 * @version: v1.0
 */
@Getter
public enum InvititationOptEnum {

    /**
     * 不区分个人邀请/企业邀请
     */
    ALL("ALL", "不区分个人/团办邀请查询"),

    /**
     * 个人邀请
     */
    PRIVATE("PRIVATE", "个人邀请查询"),

    /**
     * 企业邀请
     */
    COMPANY("COMPANY", "团办邀请查询");

    private String code;
    private String desc;

    InvititationOptEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static InvititationOptEnum getInvititationOptEnum(String code) {
        for (InvititationOptEnum type : InvititationOptEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        return null;
    }
}
