package com.fzf.study.dictionary.constant;

import lombok.Getter;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/14
 * @Version:
 * @Description:
 */


public enum MoneyConstants {
    RMB("156", "人民币");

    @Getter
    private String value;
    private String desc;

    MoneyConstants(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
