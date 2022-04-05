/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.model;

import com.fzf.study.dictionary.enums.BankEmployeeFlagEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
import com.fzf.study.dictionary.enums.InvititationOptEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/15 19:28
 * @description: 邀请卡片查询参数
 * @version: v1.0
 */
@Data
@Builder
public class CardInvitationQuery {

    /**
     * 邀请人证件号
     */
    private String inviterIdNo;

    /**
     * 行员编号
     */
    private String bankEmployeeNo;

    /**
     * 卡片申请状态
     */
    private List<CardInvitationStatusEnum> cardApplyStatus;

    /**
     * 是否行员标识
     */
    private BankEmployeeFlagEnum bankEmployeeFlagEnum;

    /**
     * 邀请性质 个人/公司
     */
    private InvititationOptEnum invititationOptEnum;

    /**
     * 开始行数
     */
    private Long firstRow;

    /**
     * 结束行数
     */
    private Long lastRow;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;
}
