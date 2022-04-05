/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.service;

import com.fzf.study.application.support.bank.invitation.builder.CardApplyInvitationBuilder;
import com.fzf.study.application.support.bank.invitation.request.CardInvitationCountQueryEmployeeRequest;
import com.fzf.study.application.support.bank.invitation.request.CardInvitationCountQueryRequest;
import com.fzf.study.application.support.bank.invitation.request.CardInvitationInfoQueryRequest;
import com.fzf.study.application.support.bank.invitation.response.CardInvitationCountQueryResponse;
import com.fzf.study.application.support.bank.invitation.response.CardInvitationInfoQueryResponse;
import com.fzf.study.dictionary.enums.BankEmployeeFlagEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusTypeEnum;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyCount;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyInvitation;
import com.fzf.study.domain.support.bank.invitation.model.CardInvitationQuery;
import com.fzf.study.domain.support.bank.invitation.repository.CardApplyInvitationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:06:31
 * @description: 小程序二维码邀请办卡查询服务
 * @version: v1.0
 */
@Service
public class CardApplyInvitationQueryService {

    @Resource
    private CardApplyInvitationRepository cardApplyInvitationRepository;

    /**
     * 查询邀请人邀请卡片各状态卡片数量-根据邀请人证件号
     *
     * @param inviterRequest 邀请人请求信息
     * @return 邀请人邀请卡片各状态邀请数量
     */
    public CardInvitationCountQueryResponse queryCardInvitationCount(CardInvitationCountQueryRequest inviterRequest) {

        //邀请办卡卡量
        List<CardApplyCount> cardApplyCountList = cardApplyInvitationRepository.countInviteeByIdNo(inviterRequest.getInviterNo(),
                BankEmployeeFlagEnum.getSearchBankEmployeeFlag(inviterRequest.getBankEmployeeFlag()));

        return processCountBuild(cardApplyCountList, inviterRequest.getInviterNo());
    }


    /**
     * 查询邀请人邀请卡片各状态卡片数量-根据行员编号
     *
     * @param request 行员查询请求对象
     * @return 邀请人邀请卡片各状态邀请数量
     */
    public CardInvitationCountQueryResponse queryCardInvitationCountByEmployeeNo(CardInvitationCountQueryEmployeeRequest request) {

        //邀请办卡卡量
        List<CardApplyCount> cardApplyCountList = cardApplyInvitationRepository.countInviteeByIdNoAndEmployeeNo(request.getBankEmployeeNo());

        return processCountBuild(cardApplyCountList, null);

    }


    /**
     * 邀请人邀请明细查询--根据证件号
     *
     * @param inviterRequest 邀请人请求信息
     * @return 邀请明细信息
     */
    public CardInvitationInfoQueryResponse queryCardInvitationInfo(CardInvitationInfoQueryRequest inviterRequest) {

        CardInvitationQuery cardInvitationQuery = CardApplyInvitationBuilder.buildCardInvitationQuery(inviterRequest);

        //邀请总量
        long totalCount = cardApplyInvitationRepository.countInviteeTotal(cardInvitationQuery);

        //邀请明细
        List<CardApplyInvitation> cardApplyInvitationList = cardApplyInvitationRepository.queryCardInvitationByInviterNo(cardInvitationQuery);

        return CardApplyInvitationBuilder.buildCardInvitationInfoQueryResponse(inviterRequest, cardApplyInvitationList, totalCount);
    }


    /**
     * 邀请人邀请明细查询--根据行员编号
     *
     * @param inviterRequest 邀请人请求信息
     * @return 邀请明细信息
     */
    public CardInvitationInfoQueryResponse queryCardInvitationInfoByEmployeeNo(CardInvitationInfoQueryRequest inviterRequest) {

        CardInvitationQuery cardInvitationQuery = CardApplyInvitationBuilder.buildCardInvitationQuery(inviterRequest);

        //邀请总量
        long totalCount = cardApplyInvitationRepository.countInviteeTotalByEmployeeNo(cardInvitationQuery);

        //邀请明细
        List<CardApplyInvitation> cardApplyInvitationList = cardApplyInvitationRepository.queryCardInvitationByEmployeeNo(cardInvitationQuery);

        return CardApplyInvitationBuilder.buildCardInvitationInfoQueryResponse(inviterRequest, cardApplyInvitationList, totalCount);
    }

    /**
     * 邀请人邀请用户各卡片状态数量
     *
     * @param cardApplyCountList 各状态卡片申请数量
     * @return 卡片申请数量返回信息
     */
    public CardInvitationCountQueryResponse processCountBuild(List<CardApplyCount> cardApplyCountList, String inviterNo) {

        //邀请办卡卡量
        long applyCount = 0;
        //审批通过的卡量
        long acceptedCount = 0;
        //已激活的卡量
        long activatedCount = 0;
        //未激活的卡量
        long notActivatedCount = 0;

        for (CardApplyCount cardApplyCount : cardApplyCountList) {

            List<CardInvitationStatusEnum> applyAllStatus = CardInvitationStatusTypeEnum.getCardInvitationStatusList(CardInvitationStatusTypeEnum.ALL);

            List<CardInvitationStatusEnum> applyAcceptedStatus = CardInvitationStatusTypeEnum.getCardInvitationStatusList(CardInvitationStatusTypeEnum.ACCEPTED);

            List<CardInvitationStatusEnum> applyActivatedStatus = CardInvitationStatusTypeEnum.getCardInvitationStatusList(CardInvitationStatusTypeEnum.ACTIVATED);

            List<CardInvitationStatusEnum> applyNotActivatedStatus = CardInvitationStatusTypeEnum.getCardInvitationStatusList(CardInvitationStatusTypeEnum.NOT_ACTIVATED);

            if (applyAllStatus.contains(cardApplyCount.getApplyStatus())) {
                applyCount = applyCount + cardApplyCount.getApplyCount();
            }
            if (applyAcceptedStatus.contains(cardApplyCount.getApplyStatus())) {
                acceptedCount = acceptedCount + cardApplyCount.getApplyCount();
            }
            if (applyActivatedStatus.contains(cardApplyCount.getApplyStatus())) {
                activatedCount = activatedCount + cardApplyCount.getApplyCount();
            }
            if (applyNotActivatedStatus.contains(cardApplyCount.getApplyStatus())) {
                notActivatedCount = notActivatedCount + cardApplyCount.getApplyCount();
            }
        }

        return CardInvitationCountQueryResponse.builder()
                .applyCount(applyCount)
                .acceptedCount(acceptedCount)
                .activatedCount(activatedCount)
                .notActivatedCount(notActivatedCount)
                .inviterNo(inviterNo)
                .build();
    }
}
