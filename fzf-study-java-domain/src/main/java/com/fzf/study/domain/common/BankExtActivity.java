/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: HouGang
 * @date: 2020/10/19 11:51
 * @description: 银行支持活动
 * @version: v1.0
 */
@Data
@Builder
public class BankExtActivity {

    /**
     * 活动id
     */
    private Long id;

    /**
     * 内部活动id
     */
    private String innerActivityId;

    /**
     * 银行活动id
     */
    private String bankActivityId;

    /**
     * 活动扩展信息
     */
    private String activityExt;

    /**
     * 活动识别码
     */
    private String activityCode;

    /**
     * 活动过期时间
     */
    private Date deadTime;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
