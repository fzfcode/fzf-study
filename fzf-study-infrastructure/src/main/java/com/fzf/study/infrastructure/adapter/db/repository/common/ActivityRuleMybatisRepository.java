/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.domain.common.ActivityRule;
import com.fzf.study.domain.common.ActivityRuleRepository;
import com.fzf.study.infrastructure.adapter.db.converter.activity.ActivityRuleConverter;
import com.fzf.study.infrastructure.adapter.db.mapper.ActivityRuleMapper;
import com.fzf.study.infrastructure.adapter.db.po.ActivityRulePO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/27 4:53 下午
 * @description: 活动规则MybatisRepository
 */
@Repository("activityRuleRepository")
public class ActivityRuleMybatisRepository implements ActivityRuleRepository {
    @Resource
    private ActivityRuleMapper activityRuleMapper;

    @Override
    public ActivityRule queryRuleInfoByActivityId(Long id, String ruleName) {
        ActivityRulePO activityRulePO = activityRuleMapper.queryByCondition(id, ruleName);
        return ActivityRuleConverter.convert2ActivityRule(activityRulePO);
    }

    @Override
    public List<ActivityRule> queryRuleInfoByRuleName(List<String> ruleName) {
        List<ActivityRulePO> activityRulePOList = activityRuleMapper.queryByRuleName(ruleName);
        return ActivityRuleConverter.convert2CardApplyInfoList(activityRulePOList);
    }
}
