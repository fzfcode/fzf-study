/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/14 9:29 下午
 * @description: 外部活动规则
 */
@Setter
@Getter
public class ExternalActivityRule {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 规则内容
     */
    private String rule;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
