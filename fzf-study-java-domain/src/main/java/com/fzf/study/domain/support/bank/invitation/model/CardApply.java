/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.model;

import com.fzf.study.dictionary.enums.CardInvitationDegreeEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
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
public class CardApply {
    /**
     * 申请号
     */
    private String appNo;

    /**
     * 审批流水号
     */
    private String applyFlowNo;

    /**
     * 申请卡号
     */
    private String cardNo;

    /**
     * 申请件状态
     */
    private CardInvitationStatusEnum cardStatus;

    /**
     * 申请人申请时间
     */
    private String applyTime;

    /**
     * 卡片激活时间
     */
    private String cardActivationTime;

    /**
     * 审批通过时间
     */
    private String approvedTime;

    /**
     * 产品类型
     */
    private String productCd;

    /**
     * 新旧户标识
     */
    private CardInvitationDegreeEnum cardInvitationDegreeEnum;
}
