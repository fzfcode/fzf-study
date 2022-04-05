/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:23
 * @description: 邀请办卡信息聚合
 * @version: v1.0
 */
@Builder
@Data
public class CardApplyInvitation {

    /**
     * 申请信息
     */
    private CardApply cardApply;

    /**
     * 被邀请人信息
     */
    private Invitee invitee;

    /**
     * 邀请人信息
     */
    private Inviter inviter;
}
