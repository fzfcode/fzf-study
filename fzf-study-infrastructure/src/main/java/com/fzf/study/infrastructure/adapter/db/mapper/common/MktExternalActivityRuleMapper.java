package com.fzf.study.infrastructure.adapter.db.mapper.common;

import com.fzf.study.infrastructure.adapter.db.po.common.ExternalActivityRulePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 2:06 下午
 * @description: 外部活动规则Mapper
 */
public interface MktExternalActivityRuleMapper {
    /**
     * 查询外部活动规则
     * @param id 活动ID
     * @param ruleValue 规则
     * @return ExternalActivityRulePO
     */
    ExternalActivityRulePO queryByCondition(@Param("activityId") Long id, @Param("ruleName") String ruleValue);

    /**
     * 查询外部活动的全部规则
     * @param id 活动ID
     * @return List<ExternalActivityRulePO>
     */
    List<ExternalActivityRulePO> queryAllRules(@Param("activityId") Long id);
}
