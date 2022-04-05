/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.converter.activity;

import com.fzf.study.domain.common.ActivityRule;
import com.fzf.study.infrastructure.adapter.db.po.ActivityRulePO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: zhujianxun
 * @date: 2020/9/27 5:00 下午
 * @description: 活动规则Converter
 */
public class ActivityRuleConverter {
    public static ActivityRule convert2ActivityRule(ActivityRulePO activityRulePO) {
        if (Objects.isNull(activityRulePO)) {
            return null;
        }

        ActivityRule activityRule = new ActivityRule();
        BeanUtils.copyProperties(activityRulePO, activityRule);
        return activityRule;
    }

    public static List<ActivityRule> convert2CardApplyInfoList(List<ActivityRulePO> activityRulePOList) {
        if (CollectionUtils.isEmpty(activityRulePOList)) {
            return Lists.newArrayList();
        }
        List<ActivityRule> activityRuleList = new ArrayList<>(activityRulePOList.size());
        activityRulePOList.forEach(activityRulePO -> {
            activityRuleList.add(convert2ActivityRule(activityRulePO));
        });
        return activityRuleList;
    }
}
