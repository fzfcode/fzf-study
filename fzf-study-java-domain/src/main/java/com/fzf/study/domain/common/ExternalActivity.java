/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import com.fzf.study.dictionary.enums.ActivityStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 2:13 下午
 * @description: 外部活动实体
 */
@Builder
@Getter
@Setter
public class ExternalActivity {
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
    private ActivityStatusEnum activityStatus;

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
