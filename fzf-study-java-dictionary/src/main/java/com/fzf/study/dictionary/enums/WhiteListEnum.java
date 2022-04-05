package com.fzf.study.dictionary.enums;


import com.fzf.study.dictionary.typehandler.LabelAndValue;

/**
 * @author: xuaimin
 * @date: 2020/10/19 下午4:05
 * @description: 白名单枚举
 */
public enum WhiteListEnum implements LabelAndValue<String> {


    ALL("all", "开放所有"),
    NONE("none", "关闭所有");

    private final String value;
    private final String label;

    WhiteListEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(Integer type) {
        for (WhiteListEnum verifyResult : WhiteListEnum.values()) {
            if (verifyResult.getValue().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static WhiteListEnum getEnum(String label) {
        for (WhiteListEnum verifyResult : WhiteListEnum.values()) {
            if (verifyResult.getLabel().equals(label)) {
                return verifyResult;
            }
        }
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }

}
