/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import com.fzf.study.dictionary.enums.ActivityConditionTypeEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2021-03-08 20:20:59
 * @description: 活动白名单分页
 */
@Data
@Builder
public class ActivityWhitelistPage {

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动规则枚举
     */
    private ActivityConditionTypeEnum activityConditionTypeEnum;

    /**
     * 白名单号
     */
    private String whiteNo;
}
