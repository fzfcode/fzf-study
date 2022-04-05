/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.mapper.invitation;

import com.fzf.study.infrastructure.adapter.db.po.invitation.CardApplyInvitationPO;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardApplyCountPO;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardInvitationQueryPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:36
 * @description: 邀请办卡Mapper
 * @version: v1.0
 */
public interface CardApplyInvitationMapper {

    /**
     * 根据审批流水号查询邀请信息
     *
     * @param applyId
     * @return 邀请信息
     */
    CardApplyInvitationPO queryCardApplyInvitationByApplyFlowNo(@Param("applyId") String applyId);


    /**
     * 新增邀请办卡进件信息
     *
     * @param cardApplyInvitationPO 进件信息
     * @return 新增进件ID
     */
    long addCardApplyInvitation(CardApplyInvitationPO cardApplyInvitationPO);

    /**
     * 非终态时更新邀请办卡进件审批状态
     *
     * @param cardApplyInvitationPO 更新进件信息
     * @return 更新进件ID
     */
    long updateInviteeInfoByApplyIdAndState(CardApplyInvitationPO cardApplyInvitationPO);

    /**
     * 更新邀请办卡进件审批状态
     *
     * @param cardApplyInvitationPO 更新进件信息
     * @return 更新进件ID
     */
    long updateInviteeInfoByApplyId(CardApplyInvitationPO cardApplyInvitationPO);

    /**
     * 更新邀请办卡卡片激活状态
     *
     * @param cardApplyInvitationPO 更新进件信息
     * @return 更新进件ID
     */
    long updateCardActivationStatusByCardNo(CardApplyInvitationPO cardApplyInvitationPO);

    /**
     * 查询被邀请申卡用户近三天被邀请数量
     *
     * @param inviteeIdNo     被邀请人证件号
     * @param applyStatusList 卡片申请状态
     * @return count
     */
    long countCardApplyPassByThreeDay(@Param("inviteeIdNo") String inviteeIdNo, @Param("applyStatusList") List<String> applyStatusList);

    /**
     * 查询邀请人邀请卡片状态卡片数量
     *
     * @param inviterIdNo      邀请人证件号
     * @param bankEmployeeFlag 是否行员
     * @return 各状态申请count
     */
    List<CardApplyCountPO> countInviteeByIdNo(@Param("inviterIdNo") String inviterIdNo, @Param("bankEmployeeFlag") String bankEmployeeFlag);

    /**
     * 查询邀请人邀请卡片状态卡片数量
     *
     * @param bankEmployeeNo  行员编号
     * @return 各状态申请count
     */
    List<CardApplyCountPO> countInviteeByIdNoAndEmployeeNo(@Param("bankEmployeeNo") String bankEmployeeNo);

    /**
     * 邀请办卡总数统计
     *
     * @param inviterIdNo      邀请人证件号
     * @param applyStatusList  卡片申请状态
     * @param bankEmployeeFlag 是否行员标识
     * @param invititationOpt  邀请性质-个人/公司
     * @return count
     */
    long countInviteeTotal(@Param("inviterIdNo") String inviterIdNo, @Param("applyStatusList") List<String> applyStatusList
            , @Param("bankEmployeeFlag") String bankEmployeeFlag, @Param("invititationOpt") String invititationOpt,
                           @Param("startDate") Date startDate, @Param("endDate") Date endDate);


    /**
     * 邀请办卡明细查询
     *
     * @param cardInvitationQueryPO 邀请卡片明细查询请求PO
     * @return 邀请明细
     */
    List<CardApplyInvitationPO> queryCardInvitationByInviterNo(CardInvitationQueryPO cardInvitationQueryPO);


    /**
     * 邀请办卡总数统计
     *
     * @param bankEmployeeNo  行员编号
     * @param applyStatusList 卡片申请状态
     * @param invititationOpt 邀请性质-个人/公司
     * @return count
     */
    long countInviteeTotalByEmployeeNo(@Param("bankEmployeeNo") String bankEmployeeNo, @Param("applyStatusList") List<String> applyStatusList
            , @Param("invititationOpt") String invititationOpt);


    /**
     * 邀请办卡明细查询--行员编号
     *
     * @param cardInvitationQueryPO 邀请卡片明细查询请求PO
     * @return 邀请明细
     */
    List<CardApplyInvitationPO> queryCardInvitationByEmployeeNo(CardInvitationQueryPO cardInvitationQueryPO);
}
