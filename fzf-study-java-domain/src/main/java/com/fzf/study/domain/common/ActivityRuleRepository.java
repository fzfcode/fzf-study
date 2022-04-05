/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/21 5:19 下午
 * @description: 活动规则Repository
 */
public interface ActivityRuleRepository {
    /**
     * 根据活动ID查询活动规则
     * @param id 活动id
     * @param ruleName 规则名称
     * @return ActivityRule
     */
    ActivityRule queryRuleInfoByActivityId(Long id, String ruleName);

    /**
     * 根据规则名称查询活动规则List
     * @param ruleName 规则名称
     * @return List<ActivityRule>
     */
    List<ActivityRule> queryRuleInfoByRuleName(List<String> ruleName);
}
