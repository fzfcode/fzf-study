/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.domain.common.ExternalActivityRule;
import com.fzf.study.domain.common.ExternalActivityRuleRepository;
import com.fzf.study.infrastructure.adapter.db.converter.activity.ExternalActivityRuleConverter;
import com.fzf.study.infrastructure.adapter.db.mapper.common.MktExternalActivityRuleMapper;
import com.fzf.study.infrastructure.adapter.db.po.common.ExternalActivityRulePO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 11:12 上午
 * @description: 活动规则MybatisRepository
 */
@Repository("externalActivityRuleRepository")
public class ExternalActivityRuleMybatisRepository implements ExternalActivityRuleRepository {
    @Resource
    private MktExternalActivityRuleMapper mktExternalActivityRuleMapper;

    @Override
    public ExternalActivityRule queryByCondition(Long id, String ruleValue) {
        ExternalActivityRulePO externalActivityRulePO = mktExternalActivityRuleMapper.queryByCondition(id, ruleValue);
        return ExternalActivityRuleConverter.convert2ExternalActivityRule(externalActivityRulePO);
    }

    @Override
    public Map<String, ExternalActivityRule> queryAllRules(Long id) {
        List<ExternalActivityRulePO> rules = mktExternalActivityRuleMapper.queryAllRules(id);
        Map<String, ExternalActivityRule> collectRuleMap = rules.stream().collect(Collectors.toMap(ExternalActivityRulePO::getRuleName, ExternalActivityRuleConverter::convert2ExternalActivityRule
        ));
        return collectRuleMap;
    }
}
