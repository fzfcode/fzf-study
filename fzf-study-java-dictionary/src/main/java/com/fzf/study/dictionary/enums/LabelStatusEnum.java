/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 5:00 下午
 * @description:
 */
@Getter
public enum  LabelStatusEnum {
    CLOSE("0","停用"),
    OPEN("1","启用");

    public String code;
    public String desc;

    LabelStatusEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static LabelStatusEnum getSearchStatusFlag(String code){
        for(LabelStatusEnum type: LabelStatusEnum.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }
}
