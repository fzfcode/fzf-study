package com.fzf.study.dictionary.enums;

public enum StatusFlagEnum {
    /**
     * 初始化
     */
    INITIALIZE("0","初始化"),
    /**
     * 受理成功
     */
    SUCCEED("1","受理成功"),
    /**
     * 受理失败
     */
    FAIL("2","受理失败");

    public String code;
    public String desc;

    StatusFlagEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static StatusFlagEnum getSearchStatusFlag(String code){
        for(StatusFlagEnum type: StatusFlagEnum.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }
}
