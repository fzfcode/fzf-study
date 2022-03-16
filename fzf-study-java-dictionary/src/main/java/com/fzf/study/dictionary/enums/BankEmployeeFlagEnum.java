package com.fzf.study.dictionary.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HouGang
 * @date: 2020-09-15 10:55:38
 * @description: 邀请卡片查询是否行员标识
 * @version: v1.0
 */
@Getter
public enum BankEmployeeFlagEnum {

    /**
     * 邀请人是银行员工
     */
    BANKEMPLOYEE("Y", "行员"),
    /**
     * 邀请人不是银行员工
     */
    NOTBANKEMPLOYEE("N", "非行员"),
    /**
     * 不区分是否为银行员工
     */
    ALL("ALL", "不区分行员");

    private String code;
    private String desc;

    BankEmployeeFlagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static final Map<String, BankEmployeeFlagEnum> MAP = new HashMap<>();

    static {
        for (BankEmployeeFlagEnum type : values()) {
            MAP.put(type.getCode(), type);
        }
    }

    public static BankEmployeeFlagEnum getSearchBankEmployeeFlag(String value) {
        return MAP.get(value);
    }

    public static BankEmployeeFlagEnum judgeBankEmployeeFlag(String bankEmployeeNo) {
        if(bankEmployeeNo==null){
            return NOTBANKEMPLOYEE;
        }else {
            return BANKEMPLOYEE;
        }
    }
}
