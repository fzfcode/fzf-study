/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.converter.activity;

import com.fzf.study.domain.common.ExternalActivityRule;
import com.fzf.study.infrastructure.adapter.db.po.common.ExternalActivityRulePO;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 2:59 下午
 * @description: 外部活动规则转换器
 */
public class ExternalActivityRuleConverter {
    public static ExternalActivityRule convert2ExternalActivityRule(ExternalActivityRulePO externalActivityRulePO) {
        if (Objects.isNull(externalActivityRulePO)) {
            return null;
        }

        ExternalActivityRule externalActivityRule = new ExternalActivityRule();
        BeanUtils.copyProperties(externalActivityRulePO, externalActivityRule);
        return externalActivityRule;
    }
}
