/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.repository;

import com.fzf.study.dictionary.enums.BankEmployeeFlagEnum;
import com.fzf.study.domain.support.bank.invitation.model.CardApply;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyCount;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyInvitation;
import com.fzf.study.domain.support.bank.invitation.model.CardInvitationQuery;

import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/10 17:05
 * @description: 小程序邀请办卡Repository
 * @version: v1.0
 */
public interface CardApplyInvitationRepository {

    /**
     * 根据审批流水号查询卡片信息
     *
     * @param appNo
     * @return 邀请信息
     */
    CardApplyInvitation queryCardApplyInvitationByApplyFlowNo(String appNo);

    /**
     * 新增邀请办卡进件信息
     *
     * @param cardApplyInvitation 邀请办卡信息聚合
     * @return 新增进件ID
     */
    long addCardApplyInvitation(CardApplyInvitation cardApplyInvitation);

    /**
     * 非终态时更新邀请办卡进件审批状态
     *
     * @param cardApply 卡片申请信息
     * @return 更新进件ID
     */
    long updateCardApplyInvitationStatusByNotFinalState(CardApply cardApply);

    /**
     * 更新邀请办卡进件审批状态
     *
     * @param cardApply 卡片申请信息
     * @return 更新进件ID
     */
    long updateCardApplyInvitationStatus(CardApply cardApply);

    /**
     * 更新邀请办卡卡片激活状态
     *
     * @param cardApply 卡片申请信息
     * @return 更新进件ID
     */
    long updateCardActivationStatus(CardApply cardApply);

    /**
     * 查询被邀请申卡用户近三天被邀请数量
     *
     * @param inviteeIdNo     被邀请人证件号
     * @param applyStatusList 卡片申请状态
     * @return count
     */
    long countCardApplyPassByThreeDay(String inviteeIdNo, List<String> applyStatusList);

    /**
     * 查询邀请人邀请卡片状态卡片数量
     *
     * @param inviterIdNo          邀请人证件号
     * @param bankEmployeeFlagEnum 是否行员
     * @return 各状态申请count
     */
    List<CardApplyCount> countInviteeByIdNo(String inviterIdNo, BankEmployeeFlagEnum bankEmployeeFlagEnum);

    /**
     * 查询邀请人邀请卡片状态卡片数量
     *
     * @param bankEmployeeNo  行员编号
     * @return 各状态申请count
     */
    List<CardApplyCount>  countInviteeByIdNoAndEmployeeNo(String bankEmployeeNo);

    /**
     * 查询邀请人邀请卡片状态卡片数量--邀请人证件号
     *
     * @param cardInvitationQuery 邀请卡片查询对象
     * @return count
     */
    long countInviteeTotal(CardInvitationQuery cardInvitationQuery);

    /**
     * 查询邀请人邀请办卡信息列表--邀请人证件号
     *
     * @param cardInvitationQuery 邀请卡片查询对象
     * @return 邀请人邀请明细信息
     */
    List<CardApplyInvitation> queryCardInvitationByInviterNo(CardInvitationQuery cardInvitationQuery);


    /**
     * 查询邀请人邀请卡片状态卡片数量--行员编号
     *
     * @param cardInvitationQuery 邀请卡片查询对象
     * @return count
     */
    long countInviteeTotalByEmployeeNo(CardInvitationQuery cardInvitationQuery);

    /**
     * 查询邀请人邀请办卡信息列表--行员编号
     *
     * @param cardInvitationQuery 邀请卡片查询对象
     * @return 邀请人邀请明细信息
     */
    List<CardApplyInvitation> queryCardInvitationByEmployeeNo(CardInvitationQuery cardInvitationQuery);

}
