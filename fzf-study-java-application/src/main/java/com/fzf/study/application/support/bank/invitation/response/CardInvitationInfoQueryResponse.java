/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询
 * @version: v1.0
 */
@Data
@Builder
public class CardInvitationInfoQueryResponse {

    /**
     * 邀请人证件号
     */
    private String inviterNo;

    /**
     * 邀请办卡卡片数量
     */
    private String cardApplyStatus;

    /**
     * 总数
     */
    private long totalRows;

    /**
     * 开始行数
     */
    private long firstRow;

    /**
     * 结束行数
     */
    private long lastRow;

    /**
     * 是否有下一页标识 Y/N
     */
    private String nextPageFlag;

    /**
     * 被邀请人明细
     */
    private List<CardInvitationInfoResponse> inviteeApplyInfoList;


}
