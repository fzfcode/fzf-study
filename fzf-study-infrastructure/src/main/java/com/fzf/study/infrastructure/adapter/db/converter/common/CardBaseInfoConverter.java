package com.fzf.study.infrastructure.adapter.db.converter.common;

import com.fzf.study.domain.common.model.CardBaseInfo;
import com.fzf.study.infrastructure.adapter.db.po.common.CardBaseInfoPO;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/15
 * @Version:
 * @Description:
 */


public class CardBaseInfoConverter {
    public static CardBaseInfo convertToCardBaseInfo(CardBaseInfoPO cardBaseInfoPO) {
        if (null == cardBaseInfoPO) {
            return null;
        }
        return CardBaseInfo.builder()
                .customerId(cardBaseInfoPO.getCustno())
                .acctNo(cardBaseInfoPO.getAcctno().longValue())
                .prodNo(cardBaseInfoPO.getProdno())
                .build();
    }
}
