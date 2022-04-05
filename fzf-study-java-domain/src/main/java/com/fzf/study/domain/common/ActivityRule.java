/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/21 5:19 下午
 * @description: 活动规则
 */
@Getter
@Setter
@EqualsAndHashCode
public class ActivityRule {
    /**
     * 主键
     */
    private Long id;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 事件类型
     */
    private Integer eventType;
    /**
     * 规则内容
     */
    private String ruleValue;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 描述
     */
    private String description;
    /**
     * 添加事件
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 规则内容的数据类型
     */
    private String valueFormatType;
}
