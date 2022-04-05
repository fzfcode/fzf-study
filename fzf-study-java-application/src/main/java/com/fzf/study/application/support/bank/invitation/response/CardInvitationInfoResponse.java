/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询
 * @version: v1.0
 */
@Data
@Builder
public class CardInvitationInfoResponse {

    /**
     * 邀请人姓名
     */
    private String inviterName;

    /**
     * 被邀请人姓名
     */
    private String inviteeName;

    /**
     * 被邀请人手机号
     */
    private String inviteePhone;

    /**
     * 申请日期
     */
    private String applyDate;

    /**
     * 激活日期
     */
    private String activateDate;

    /**
     * 优质企业编号
     */
    private String companyId;

    /**
     * 优质企业名称
     */
    private String companyName;

    /**
     * 企业简称
     */
    private String companyShortName;

    /**
     * 卡片状态
     */
    private String status;

    /**
     * 是否行员标识
     */
    private String bankEmployeeFlag;

    /**
     * 推荐人网点
     */
    private String recomenderBankBranch;

    /**
     * 卡片审批通过时间
     */
    private String cardApprovedDate;

}
