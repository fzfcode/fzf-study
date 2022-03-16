package com.fzf.study.dictionary.enums;

public enum KeyTypeEnum {
    /**
     * 申请编号
     */
    APPLYNO("A","申请编号"),
    /**
     * 卡号
     */
    CARDNO("C","卡号"),
    /**
     * 证件号
     */
    IDNO("I","证件号");

    public String code;
    public String desc;

    KeyTypeEnum(String code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static KeyTypeEnum getSearchKeyType(String code){
        for(KeyTypeEnum type: KeyTypeEnum.values()){
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }
}
