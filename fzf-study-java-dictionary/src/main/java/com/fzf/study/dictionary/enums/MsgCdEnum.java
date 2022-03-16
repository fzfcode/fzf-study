package com.fzf.study.dictionary.enums;

/**
 * @author: zhujianxun
 * @date: 2020/10/21 3:42 下午
 * @description: msgCd枚举
 */
public enum MsgCdEnum {

    MARKETING_07("marketing_07"),
    MARKETING_SIGN_UP("marketing_sign_up");

    private String code;

    MsgCdEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
