/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.converter.activity;

import com.fzf.study.dictionary.enums.ActivityStatusEnum;
import com.fzf.study.domain.common.ExternalActivity;
import com.fzf.study.infrastructure.adapter.db.po.common.ExternalActivityPO;

import java.util.Objects;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 2:55 下午
 * @description: 外部活动转换器
 */
public class ExternalActivityConverter {
    public static ExternalActivity convert2ExternalActivity(ExternalActivityPO activityPO) {
        if (Objects.isNull(activityPO)) {
            return null;
        }

        return ExternalActivity.builder()
                .activityDesc(activityPO.getActivityDesc())
                .activityName(activityPO.getActivityName())
                .id(activityPO.getId())
                .activityType(activityPO.getActivityType())
                .addTime(activityPO.getAddTime())
                .updateTime(activityPO.getUpdateTime())
                .activityStatus(ActivityStatusEnum.getEnum(activityPO.getActivityStatus()))
                .build();
    }
}
