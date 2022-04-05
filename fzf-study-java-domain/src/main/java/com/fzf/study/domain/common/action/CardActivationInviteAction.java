/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.action;

import com.fzf.study.domain.common.ActiveEventRecord;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/21 2:35 下午
 * @description: 卡片激活邀请达标行为
 */
@Builder
@Getter
@EqualsAndHashCode
public class CardActivationInviteAction implements ActivityAction{
    /**
     * 活动事项记录list
     */
    private List<ActiveEventRecord> activeRecordEventList;

    /**
     * 下行短信模版
     */
    private String smsContent;
}
