/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: HouGang
 * @date: 2021-03-08 20:20:59
 * @description: 活动扩展信息记录
 */
@Builder
@Data
public class MktRuleDetail {
    /**
     * 主键
     */
    private Long id;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 规则码值
     */
    private String ruleCode;

    /**
     * 规则内容
     */
    private String ruleUnitValue;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
