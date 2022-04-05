/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po;


import lombok.Data;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 11:19 上午
 * @description: 外部活动规则PO
 */
@Data
public class ExternalActivityRulePO {
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
