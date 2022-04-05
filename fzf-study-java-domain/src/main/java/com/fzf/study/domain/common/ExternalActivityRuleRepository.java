package com.fzf.study.domain.common;

import java.util.Map;

/**
 * @author: zhujianxun
 * @date: 2020/9/14 9:34 下午
 * @description: 外部活动信息Repository
 */
public interface ExternalActivityRuleRepository {
    /**
     * 根据条件查询外部活动规则
     * @param id id
     * @param ruleValue 规则名称
     * @return ExternalActivityRule
     */
    ExternalActivityRule queryByCondition(Long id, String ruleValue);


    /**
     * 查询活动的全部规则
     * @param id
     * @return
     */
    Map<String, ExternalActivityRule> queryAllRules(Long id);
}
