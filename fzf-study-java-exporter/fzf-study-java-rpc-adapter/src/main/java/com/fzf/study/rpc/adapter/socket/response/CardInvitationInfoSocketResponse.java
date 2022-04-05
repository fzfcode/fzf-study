/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.response;

import com.fzf.study.rpc.adapter.socket.annotation.RespXmlElement;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询
 * @version: v1.0
 */
@Data
@RespXmlElement(elementName = "APPLY")
public class CardInvitationInfoSocketResponse {

    /**
     * 邀请人姓名
     */
    @RespXmlElement(elementName = "INVITER_NAME")
    private String inviterName;

    /**
     * 被邀请人姓名
     */
    @RespXmlElement(elementName = "INVITEE_NAME")
    private String inviteeName;

    /**
     * 被邀请人手机号
     */
    @RespXmlElement(elementName = "INVITEE_PHONE")
    private String inviteePhone;

    /**
     * 申请日期
     */
    @RespXmlElement(elementName = "APPLY_DATE")
    private String applyDate;

    /**
     * 激活日期
     */
    @RespXmlElement(elementName = "ACTIVATE_DATE")
    private String activateDate;

    /**
     * 优质企业编号
     */
    @RespXmlElement(elementName = "COMPANY_ID")
    private String companyId;

    /**
     * 优质企业名称
     */
    @RespXmlElement(elementName = "COMPANY_NAME")
    private String companyName;

    /**
     * 企业简称
     */
    @RespXmlElement(elementName = "COMPANY_SHORT_NAME")
    private String companyShortName;

    /**
     * 卡片状态
     */
    @RespXmlElement(elementName = "STATUS")
    private String status;

    /**
     * 是否行员标识
     */
    @RespXmlElement(elementName = "BANK_EMPLOYEEFLAG")
    private String bankEmployeeFlag;

    /**
     * 推荐人网点
     */
    @RespXmlElement(elementName = "RECOMENDER_BANKBRANCH")
    private String recomenderBankBranch;

    /**
     * 卡片审批通过时间
     */
    @RespXmlElement(elementName = "CARD_APPROVED_DATE")
    private String cardApprovedDate;

}
