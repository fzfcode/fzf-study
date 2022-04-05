package com.fzf.study.dictionary.enums;


import com.fzf.study.dictionary.typehandler.LabelAndValue;

/**
 * @author: xuaimin
 * @date: 2020/10/13 下午2:37
 * @description: 金融交易方向枚举
 */
public enum TradeDirectionEnum implements LabelAndValue<String> {

    NORMAl_TRADE("Normal", "正向交易");

    private final String value;
    private final String label;

    TradeDirectionEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(Integer type) {
        for (TradeDirectionEnum verifyResult : TradeDirectionEnum.values()) {
            if (verifyResult.getValue().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static TradeDirectionEnum getEnum(String label) {
        for (TradeDirectionEnum verifyResult : TradeDirectionEnum.values()) {
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
