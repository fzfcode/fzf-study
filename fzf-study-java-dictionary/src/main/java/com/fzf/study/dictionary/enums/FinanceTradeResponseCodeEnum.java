package com.fzf.study.dictionary.enums;

import com.sankuai.meituan.mkt.activity.dictionary.typehandler.LabelAndValue;

/**
 * @author: xuaimin
 * @date: 2020/10/13 上午11:58
 * @description: 金融交易
 */
public enum FinanceTradeResponseCodeEnum implements LabelAndValue<String> {

    SUCCESS_CODE("00", "成功");

    private final String value;
    private final String label;

    FinanceTradeResponseCodeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(Integer type) {
        for (FinanceTradeResponseCodeEnum verifyResult : FinanceTradeResponseCodeEnum.values()) {
            if (verifyResult.getValue().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static FinanceTradeResponseCodeEnum getEnum(String label) {
        for (FinanceTradeResponseCodeEnum verifyResult : FinanceTradeResponseCodeEnum.values()) {
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
