/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.response;

import com.fzf.study.rpc.adapter.socket.annotation.RespXmlElement;
import com.fzf.study.rpc.adapter.socket.annotation.RespXmlListElement;
import lombok.Data;

import java.util.List;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询
 * @version: v1.0
 */
@Data
@RespXmlElement(elementName = "")
public class CardInvitationInfoQuerySocketResponse {

    /**
     * 邀请人证件号
     */
    @RespXmlElement(elementName = "ID_NO")
    private String inviterNo;

    /**
     * 邀请办卡卡片数量
     */
    @RespXmlElement(elementName = "STATUS")
    private String cardApplyStatus;

    /**
     * 总数
     */
    @RespXmlElement(elementName = "TOTAL_ROWS")
    private long totalRows;

    /**
     * 开始行数
     */
    @RespXmlElement(elementName = "FIRSTROW")
    private long firstRow;

    /**
     * 结束行数
     */
    @RespXmlElement(elementName = "LASTROW")
    private long lastRow;

    /**
     * 是否有下一页标识 Y/N
     */
    @RespXmlElement(elementName = "NEXTPAGE_FLG")
    private String nextPageFlag;

    /**
     * 被邀请人明细
     */
    @RespXmlListElement(elementName = "APPLYLIST", subType = Apply.class)
    private List<Apply> inviteeApplyInfoList;


    @RespXmlElement(elementName = "APPLY")
    @Data
    public static class Apply {
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

}
