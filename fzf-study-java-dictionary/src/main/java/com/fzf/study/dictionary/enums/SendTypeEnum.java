package com.fzf.study.dictionary.enums;

public enum SendTypeEnum {
    /**
     * 批量发送
     */
    BATCH("batch","批量发送"),
    /**
     * 实时发送
     */
    RIGHTNOW("rightnow","实时发送");

    public String code;
    public String desc;

    SendTypeEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static SendTypeEnum getSearchSendType(String code){
        for(SendTypeEnum type: SendTypeEnum.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }
}
