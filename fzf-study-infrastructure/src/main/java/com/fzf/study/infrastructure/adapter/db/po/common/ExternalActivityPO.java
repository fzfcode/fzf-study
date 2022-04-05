/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po.common;

import lombok.Data;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 2:08 下午
 * @description: 外部活动PO
 */
@Data
public class ExternalActivityPO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 活动状态
     */
    private Integer activityStatus;

    /**
     * 活动类型
     */
    private String activityType;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
