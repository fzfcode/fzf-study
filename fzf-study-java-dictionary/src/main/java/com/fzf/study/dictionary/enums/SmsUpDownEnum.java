package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 5:02 下午
 * @description:
 */
@Getter
public enum SmsUpDownEnum {
    ONEWAY("0","单向短信"),
    TWOWAY("1","双向短信");

    public String code;
    public String desc;

    SmsUpDownEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static SmsUpDownEnum getSearchStatusFlag(String code){
        for(SmsUpDownEnum type: SmsUpDownEnum.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }
}
