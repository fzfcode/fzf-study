/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.builder;

import com.fzf.study.application.support.bank.invitation.request.CardActivationUpdateRequest;
import com.fzf.study.application.support.bank.invitation.request.CardApplyInvitationAddRequest;
import com.fzf.study.application.support.bank.invitation.request.CardApplyInvitationUpdateRequest;
import com.fzf.study.application.support.bank.invitation.request.CardInvitationInfoQueryRequest;
import com.fzf.study.application.support.bank.invitation.response.CardInvitationInfoQueryResponse;
import com.fzf.study.application.support.bank.invitation.response.CardInvitationInfoResponse;
import com.fzf.study.common.TimeUtils;
import com.fzf.study.dictionary.enums.*;
import com.fzf.study.domain.support.bank.invitation.model.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/10 14:52
 * @description: 邀请办卡业务对象构造器
 * @version: v1.0
 */
public class CardApplyInvitationBuilder {

    /**
     * 通过申卡请求信息组装邀请人和被邀请人信息聚合对象
     *
     * @param inviter                  邀请人补充信息
     * @param addInfo                  申卡信息
     * @param cardInvitationDegreeEnum 卡片新旧户状态
     * @return 邀请办卡信息聚合对象
     */
    public static CardApplyInvitation build(Inviter inviter, CardApplyInvitationAddRequest addInfo
            , CardInvitationDegreeEnum cardInvitationDegreeEnum) {

        //申请信息
        CardApply cardApply = CardApply.builder()
                .appNo(addInfo.getAppNo())
                .applyFlowNo(addInfo.getApplyFlowNo())
                .cardNo(addInfo.getCardNo())
                .applyTime(addInfo.getApplyTime())
                .productCd(addInfo.getProductCd())
                .cardStatus(CardInvitationStatusEnum.MAIN_INFO_COMMIT)
                .cardInvitationDegreeEnum(cardInvitationDegreeEnum)
                .build();

        // 被邀请人信息
        Invitee invitee = Invitee.builder()
                .inviteeName(addInfo.getName())
                .inviteePhone(addInfo.getCellPhone())
                .inviteeIdNo(addInfo.getIdNo())
                .build();

        //邀请人客户号处理
        long inviterCustomerNo = StringUtils.isNumeric(addInfo.getReferrerInfo()) ? Long.parseLong(addInfo.getReferrerInfo())
                : 0;

        // 邀请人信息
        Inviter inviterBuild = Inviter.builder().bankEmployeeNo(addInfo.getRecomenderId())
                .inviterBankBranchNo(addInfo.getRecomenderBankBranch())
                .inviterCustomerNo(inviterCustomerNo)
                .highualityCompanyCode(addInfo.getGroupInfo())
                .inviterName(inviter.getInviterName())
                .inviterIdNo(inviter.getInviterIdNo())
                .build();

        return CardApplyInvitation.builder().cardApply(cardApply).invitee(invitee).inviter(inviterBuild).build();
    }


    /**
     * 被邀请人卡片申请信息更新
     *
     * @param updateRequest            卡片审批更新信息
     * @param cardInvitationDegreeEnum 卡片新旧户状态
     * @return 卡片申请信息
     */
    public static CardApply buildCardApply(CardApplyInvitationUpdateRequest updateRequest, CardInvitationDegreeEnum cardInvitationDegreeEnum) {

        //根据申请进件类型，获取卡片状态
        CardInvitationStatusEnum cardInvitationStatusEnum =
                CardInvitationStatusEnum.getCardStatusByMessageType(updateRequest.getMessageType());

        //申请信息
        return CardApply.builder()
                .applyFlowNo(updateRequest.getApplyFlowNo())
                .cardNo(updateRequest.getCardNo())
                .approvedTime(updateRequest.getApproveTime())
                .cardStatus(cardInvitationStatusEnum)
                .cardInvitationDegreeEnum(cardInvitationDegreeEnum)
                .build();

    }


    /**
     * 被邀请人卡片激活信息更新聚合对象
     *
     * @param updateRequest 卡片激活更新信息
     * @return 卡片申请信息
     */
    public static CardApply buildActivationCardApply(CardActivationUpdateRequest updateRequest) {
        // 卡片申请信息
        return CardApply.builder()
                .cardNo(updateRequest.getCardNo())
                .cardActivationTime(TimeUtils.format(new Date()))
                .cardStatus(CardInvitationStatusEnum.CARD_ACTIVATED)
                .build();
    }


    /**
     * 邀请办卡明细查询请求对象
     *
     * @param queryRequest 邀请人查询请求信息
     * @return 邀请信息请求对象
     */
    public static CardInvitationQuery buildCardInvitationQuery(CardInvitationInfoQueryRequest queryRequest) {

        //获取卡片状态列表
        List<CardInvitationStatusEnum> cardStatusList = CardInvitationStatusTypeEnum.getCardInvitationStatusList
                (CardInvitationStatusTypeEnum.getSearchTypeByCode(queryRequest.getCardStatus()));

        return CardInvitationQuery.builder()
                .inviterIdNo(queryRequest.getInviterNo())
                .bankEmployeeNo(queryRequest.getBankEmployeeNo())
                .cardApplyStatus(cardStatusList)
                .bankEmployeeFlagEnum(BankEmployeeFlagEnum.getSearchBankEmployeeFlag(queryRequest.getBankEmployeeFlag()))
                .invititationOptEnum(InvititationOptEnum.getInvititationOptEnum(queryRequest.getSearchType()))
                .firstRow(queryRequest.getFirstRow())
                .lastRow(queryRequest.getLastRow())
                .startDate(queryRequest.getStartDate())
                .endDate(queryRequest.getEndDate())
                .build();
    }


    /**
     * 邀请办卡明细查询请求对象
     *
     * @param inviterRequest          邀请人查询请求信息
     * @param cardApplyInvitationList 邀请人邀请办卡新
     * @param totalCount              邀请办卡总数
     * @return 邀请信息请求对象
     */
    public static CardInvitationInfoQueryResponse buildCardInvitationInfoQueryResponse(CardInvitationInfoQueryRequest inviterRequest,
                                                                                       List<CardApplyInvitation> cardApplyInvitationList, long totalCount) {

        List<CardInvitationInfoResponse> inviteeList = new ArrayList<>();
        for (CardApplyInvitation cardApplyInvitation : cardApplyInvitationList) {
            CardInvitationInfoResponse cardInvitationInfoResponse = CardInvitationInfoResponse.builder()
                    .inviterName(cardApplyInvitation.getInviter().getInviterName())
                    .inviteeName(cardApplyInvitation.getInvitee().getInviteeName())
                    .inviteePhone(cardApplyInvitation.getInvitee().getInviteePhone())
                    .applyDate(cardApplyInvitation.getCardApply().getApplyTime())
                    .activateDate(cardApplyInvitation.getCardApply().getCardActivationTime())
                    .cardApprovedDate(cardApplyInvitation.getCardApply().getApprovedTime())
                    .companyId(cardApplyInvitation.getInviter().getHighualityCompanyCode())
                    .companyName(cardApplyInvitation.getInviter().getHighualityCompanyName())
                    .companyShortName(cardApplyInvitation.getInviter().getHighualityCompanyShortName())
                    .status(cardApplyInvitation.getCardApply().getCardStatus().getCode())
                    .bankEmployeeFlag(BankEmployeeFlagEnum.judgeBankEmployeeFlag(cardApplyInvitation.getInviter().getBankEmployeeNo()).getCode())
                    .recomenderBankBranch(cardApplyInvitation.getInviter().getInviterBankBranchNo())
                    .build();

            inviteeList.add(cardInvitationInfoResponse);
        }

        return CardInvitationInfoQueryResponse.builder()
                .inviterNo(inviterRequest.getInviterNo())
                .cardApplyStatus(inviterRequest.getCardStatus())
                .totalRows(totalCount)
                .firstRow(inviterRequest.getFirstRow())
                .lastRow(inviterRequest.getLastRow())
                .inviteeApplyInfoList(inviteeList)
                .build();
    }
}
