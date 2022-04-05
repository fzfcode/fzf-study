/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.converter.invitation;

import com.fzf.study.dictionary.enums.CardInvitationDegreeEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
import com.fzf.study.domain.support.bank.invitation.model.*;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardApplyCountPO;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardApplyInvitationPO;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardInvitationQueryPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: HouGang
 * @date: 2020/9/12 19:14
 * @description: 邀请办卡转换器
 * @version: v1.0
 */
public class CardApplyInvitationConverter {


    public static CardApplyInvitation convert2CardApplyInvitation(
            CardApplyInvitationPO cardApplyInvitationPO) {
        if (Objects.isNull(cardApplyInvitationPO)) {
            return null;
        }

        //申请信息
        CardApply cardApply = CardApply.builder()
                .applyFlowNo(cardApplyInvitationPO.getApplyId())
                .cardNo(cardApplyInvitationPO.getCardNo())
                .applyTime(cardApplyInvitationPO.getApplyTime())
                .cardActivationTime(cardApplyInvitationPO.getCardActivTime())
                .approvedTime(cardApplyInvitationPO.getApsPassTime())
                .productCd(cardApplyInvitationPO.getProdCd())
                .cardStatus(CardInvitationStatusEnum.getCardStatusByCode(cardApplyInvitationPO.getApplyStatus()))
                .cardInvitationDegreeEnum(CardInvitationDegreeEnum.getSearchOptByCode(cardApplyInvitationPO.getAcctCustIdentify()))
                .build();


        // 被邀请人信息
        Invitee invitee = Invitee.builder()
                .inviteeName(cardApplyInvitationPO.getInviteeName())
                .inviteePhone(cardApplyInvitationPO.getInviteePhone())
                .inviteeIdNo(cardApplyInvitationPO.getInviteeIdNo())
                .build();

        //邀请人信息转换
        Inviter inviter = Inviter.builder()
                .inviterCustomerNo(cardApplyInvitationPO.getInviterCustId())
                .highualityCompanyCode(cardApplyInvitationPO.getGoodComCode())
                .bankEmployeeNo(cardApplyInvitationPO.getInviterJobNo())
                .inviterBankBranchNo(cardApplyInvitationPO.getInviterBranchNo())
                .inviterName(cardApplyInvitationPO.getInviterName())
                .inviterIdNo(cardApplyInvitationPO.getInviterIdNo())
                .highualityCompanyName(cardApplyInvitationPO.getGoodComName())
                .highualityCompanyShortName(cardApplyInvitationPO.getGoodComShort())
                .build();

        return CardApplyInvitation.builder()
                .cardApply(cardApply)
                .invitee(invitee)
                .inviter(inviter)
                .build();
    }

    public static CardApplyInvitationPO convert2CardApplyInvitation(
            CardApplyInvitation cardApplyInvitation) {

        return CardApplyInvitationPO.builder()
                // 被邀请人信息
                .applyId(cardApplyInvitation.getCardApply().getApplyFlowNo())
                .inviteeName(cardApplyInvitation.getInvitee().getInviteeName())
                .prodCd(cardApplyInvitation.getCardApply().getProductCd())
                .inviteeIdNo(cardApplyInvitation.getInvitee().getInviteeIdNo())
                .inviteePhone(cardApplyInvitation.getInvitee().getInviteePhone())
                .applyTime(cardApplyInvitation.getCardApply().getApplyTime())
                .applyStatus(cardApplyInvitation.getCardApply().getCardStatus().getCode())
                .acctCustIdentify(cardApplyInvitation.getCardApply()
                        .getCardInvitationDegreeEnum().getCode())
                // 邀请人信息
                .inviterCustId(cardApplyInvitation.getInviter().getInviterCustomerNo())
                .goodComCode(cardApplyInvitation.getInviter().getHighualityCompanyCode())
                .inviterJobNo(cardApplyInvitation.getInviter().getBankEmployeeNo())
                .inviterBranchNo(cardApplyInvitation.getInviter().getInviterBankBranchNo())
                .inviterName(cardApplyInvitation.getInviter().getInviterName())
                .inviterIdNo(cardApplyInvitation.getInviter().getInviterIdNo())
                .build();

    }

    public static CardApplyInvitationPO convert2CardApply(
            CardApply cardApply) {
        // 卡片申请信息
        return CardApplyInvitationPO.builder()
                .applyId(cardApply.getApplyFlowNo())
                .cardNo(cardApply.getCardNo())
                .apsPassTime(cardApply.getApprovedTime())
                .applyStatus(cardApply.getCardStatus().getCode())
                .build();
    }


    public static CardApplyInvitationPO convert2ActivationCardApply(
            CardApply cardApply) {
        // 卡片申请信息
        return CardApplyInvitationPO.builder()
                .cardNo(cardApply.getCardNo())
                .cardActivTime(cardApply.getCardActivationTime())
                .applyStatus(cardApply.getCardStatus().getCode())
                .build();
    }

    public static CardInvitationQueryPO convert2CardInvitationQuery(
            CardInvitationQuery cardInvitationQuery) {
        // 邀请办卡明细查询PO
        return CardInvitationQueryPO.builder()
                .inviterIdNo(cardInvitationQuery.getInviterIdNo())
                .bankEmployeeNo(cardInvitationQuery.getBankEmployeeNo())
                .cardApplyStatusList(convert2CardStatusList(cardInvitationQuery.getCardApplyStatus()))
                .bankEmployeeFlag(cardInvitationQuery.getBankEmployeeFlagEnum().getCode())
                .invititationOpt(cardInvitationQuery.getInvititationOptEnum().getCode())
                .firstRow(cardInvitationQuery.getFirstRow())
                .lastRow(cardInvitationQuery.getLastRow() - cardInvitationQuery.getFirstRow() + 1)
                .startDate(cardInvitationQuery.getStartDate())
                .endDate(cardInvitationQuery.getEndDate())
                .build();
    }


    public static CardInvitationQueryPO convert2CardInvitationQueryByEmployeeNo(
            CardInvitationQuery cardInvitationQuery) {
        // 邀请办卡明细查询PO
        return CardInvitationQueryPO.builder()
                .bankEmployeeNo(cardInvitationQuery.getBankEmployeeNo())
                .cardApplyStatusList(convert2CardStatusList(cardInvitationQuery.getCardApplyStatus()))
                .invititationOpt(cardInvitationQuery.getInvititationOptEnum().getCode())
                .firstRow(cardInvitationQuery.getFirstRow())
                .lastRow(cardInvitationQuery.getLastRow() - cardInvitationQuery.getFirstRow() + 1)
                .build();
    }

    public static List<CardApplyCount> convert2CardApplyCount(List<CardApplyCountPO> cardApplyCountPOList) {
        List<CardApplyCount> list = new ArrayList<>();
        for (CardApplyCountPO cardApplyCountPO : cardApplyCountPOList) {
            CardApplyCount cardApplyCount = CardApplyCount.builder()
                    .applyStatus(CardInvitationStatusEnum.getCardStatusByCode(cardApplyCountPO.getApplyStatus()))
                    .applyCount(cardApplyCountPO.getApplyCount())
                    .build();
            list.add(cardApplyCount);

        }
        return list;
    }

    public static List<String> convert2CardStatusList(List<CardInvitationStatusEnum> cardInvitationStatusEnumList) {
        List<String> list = new ArrayList<>();
        for (CardInvitationStatusEnum cardInvitationStatusEnum : cardInvitationStatusEnumList) {
            list.add(cardInvitationStatusEnum.getCode());
        }
        return list;
    }
}
