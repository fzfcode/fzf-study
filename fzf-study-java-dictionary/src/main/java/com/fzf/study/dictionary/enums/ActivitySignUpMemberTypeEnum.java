package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020-10-16 16:54:32
 * @description: 活动报名渠道Enum
 * @version: v1.0
 */
@Getter
public enum ActivitySignUpMemberTypeEnum {

    /**
     * 身份证
     */
    ID_TYPE(1,"I", "身份证"),

    /**
     * 卡号
     */
    CARD(2,"C", "卡号"),
    ;

    private Integer codeNo;
    private String codeValue;
    private String desc;

    ActivitySignUpMemberTypeEnum(Integer codeNo, String codeValue, String desc) {
        this.codeNo = codeNo;
        this.codeValue=codeValue;
        this.desc = desc;
    }

    public static final Map<Integer, ActivitySignUpMemberTypeEnum> NOMAP = new HashMap<>();

    public static final Map<String, ActivitySignUpMemberTypeEnum> CODEMAP = new HashMap<>();

    static {
        for (ActivitySignUpMemberTypeEnum type : values()) {
            NOMAP.put(type.getCodeNo(), type);
            CODEMAP.put(type.getCodeValue(), type);
        }
    }

    public static ActivitySignUpMemberTypeEnum getMemberTypeEumByValue(String value) {
        return CODEMAP.get(value);
    }

    public static ActivitySignUpMemberTypeEnum getMemberTypeEumByCode(Integer codeNo) {
        return NOMAP.get(codeNo);
    }

}
