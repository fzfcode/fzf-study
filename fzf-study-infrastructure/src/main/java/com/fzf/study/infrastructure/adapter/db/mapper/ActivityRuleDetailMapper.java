package com.fzf.study.infrastructure.adapter.db.mapper;

import com.fzf.study.infrastructure.adapter.db.po.MktRuleDetailMaxMinIdPO;
import com.fzf.study.infrastructure.adapter.db.po.ActivityRuleDetailPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/9/12 5:42 下午
 * @description: 活动规则详情Mapper
 */
public interface ActivityRuleDetailMapper {

    /**
     * 批量添加活动规则详情
     *
     * @param activityId    活动id
     * @param ruleCode      活动规则编码
     * @param ruleValueList 规则值列表
     * @return 影响行数
     */
    int addList(@Param("activityId") Long activityId,
                @Param("ruleCode") String ruleCode,
                @Param("ruleValueList") List<String> ruleValueList);

    /**
     * 查询活动指定规则编码下规则值总数
     *
     * @param activityId 活动id
     * @param ruleCode   活动规则编码
     * @return 规则值总数
     */
    int count(@Param("activityId") Long activityId, @Param("ruleCode") String ruleCode);

    /**
     * 查询活动指定规则编码下指定规则值数量
     *
     * @param activityId 活动id
     * @param ruleCode   活动规则编码
     * @param ruleValue  规则值
     * @return 规则值总数
     */
    int countWithValue(@Param("activityId") Long activityId, @Param("ruleCode") String ruleCode, @Param("ruleValue") String ruleValue);


    /**
     * 查询活动指定规则编码下最大ID&最小ID
     *
     * @param activityId 活动id
     * @param ruleCode   活动规则编码
     * @return 最大ID&最小ID对象
     */
    MktRuleDetailMaxMinIdPO queryMaxMinId(@Param("activityId") Long activityId, @Param("ruleCode") String ruleCode);


    /**
     * 查询活动指定规则编码下指定规则值数量
     *
     * @param activityId 活动id
     * @param ruleCode   活动规则编码
     * @param ruleValue  规则值
     * @return 规则值总数
     */
    int countWithValue2(@Param("activityId") Long activityId, @Param("ruleCode") String ruleCode, @Param("ruleValue") String ruleValue);

    /**
     * 查询活动指定规则编码ID范围内的值
     *
     * @param activityId 活动id
     * @param ruleCode   活动规则编码
     * @return 最大ID&最小ID对象
     */
    List<String> queryBatchActivityRuleUnitValue(@Param("activityId") Long activityId,
                                                 @Param("ruleCode") String ruleCode, @Param("minId") Long minId, @Param("maxId") Long maxId);

    /**
     * 分页查询活动指定规则编码值
     *
     * @param startIndex    取数据起点
     * @param size          数据数量
     * @param activityId    活动ID
     * @param ruleCode      规则码值
     * @param ruleUnitValue 规则值
     * @return
     */
    List<ActivityRuleDetailPO> queryPageByActivityIdAndRuleCode(@Param("startIndex") Integer startIndex, @Param("size") Integer size,
                                                                @Param("activityId") Long activityId, @Param("ruleCode") String ruleCode,
                                                                @Param("ruleUnitValue") String ruleUnitValue);
    /**
     * 批量删除活动规则详情
     *
     * @param idList        规则idList
     * @return 影响行数
     */
    int deleteList(@Param("idList") List<Long> idList);

    /**
     * 修改活动规则
     *
     * @param id            id
     * @param activityId    活动ID
     * @param ruleUnitValue 规则值
     * @return 影响行数
     */
    int updateValue(@Param("id") Long id,
                    @Param("activityId") Long activityId,
                    @Param("ruleUnitValue") String ruleUnitValue);

}
