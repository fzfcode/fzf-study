package com.fzf.study.infrastructure.adapter.db.mapper;

import com.fzf.study.infrastructure.adapter.db.po.ActivityRulePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author: SunKe
 * @date: 2020/9/12 5:30 下午
 * @description: 活动规则Mapper
 */
public interface ActivityRuleMapper {

    /**
     * 批量新增活动规则
     * @param activityRulePoList 活动规则列表
     * @return 新增行数
     */
    int addList(List<ActivityRulePO> activityRulePoList);

    /**
     * 根据条件查询活动规则
     * @param activityId 活动Id
     * @param ruleName 规则名称
     * @return ActivityRulePO
     */
    ActivityRulePO queryByCondition(@Param("activityId") Long activityId, @Param("ruleName") String ruleName);

    /**
     * 根据规则名称查询活动规则List
     * @param ruleName 规则名称
     * @return List<ActivityRulePO>
     */
    List<ActivityRulePO> queryByRuleName(@Param("ruleNameList") List<String> ruleName);

    /**
     * 批量新增活动规则
     * @param activityRulePoList 活动规则列表
     * @return 新增行数
     */
    int upsertList(List<ActivityRulePO> activityRulePoList);

    /**
     * 批量查询活动规则列表
     * @param activityIds 活动id列表
     * @return 活动规则列表
     */
    List<ActivityRulePO> queryListByActivityIds(@Param("activityIds") List<Long> activityIds);

    /**
     * 查询活动规则列表
     * @param activityId 活动id
     * @return 活动规则列表
     */
    List<ActivityRulePO> queryListByActivityId(@Param("activityId") Long activityId);

    /**
     * 批量更新活动规则
     * @param activityRulePo 活动规则列表
     * @return 新增行数
     */
    int updateRule(ActivityRulePO activityRulePo);


    Optional<String> queryRuleByRuleName(@Param("ruleName") String ruleName);
}
