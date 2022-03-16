package com.fzf.study.dictionary.enums;

import com.sankuai.meituan.mkt.activity.dictionary.typehandler.LabelAndValue;

/**
 * @author: xuaimin
 * @date: 2020/10/13 下午3:07
 * @description: 交易类型
 */
public enum TradeTypeEnum implements LabelAndValue<String> {

    AUTH_TRADE("Auth", "消费"),
    AGENT_DEBIT_TRADE("AgentDebit", "代收"),
    PA_COMP_TRADE("PAComp", "预授权完成");

    private final String value;
    private final String label;

    TradeTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public static boolean contains(Integer type) {
        for (TradeTypeEnum verifyResult : TradeTypeEnum.values()) {
            if (verifyResult.getValue().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static TradeTypeEnum getEnum(String label) {
        for (TradeTypeEnum verifyResult : TradeTypeEnum.values()) {
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
