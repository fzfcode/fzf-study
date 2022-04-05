package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/12 5:31 下午
 * @description: 活动规则详情PO
 */
@Builder
@Data
public class ActivityRuleDetailPO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 事件类型
     */
    private String ruleCode;

    /**
     * 规则名称
     */
    private String ruleUnitValue;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
