/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.repository.invitation;

import com.fzf.study.dictionary.enums.BankEmployeeFlagEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
import com.fzf.study.domain.support.bank.invitation.model.CardApply;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyCount;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyInvitation;
import com.fzf.study.domain.support.bank.invitation.model.CardInvitationQuery;
import com.fzf.study.domain.support.bank.invitation.repository.CardApplyInvitationRepository;
import com.fzf.study.infrastructure.adapter.db.converter.invitation.CardApplyInvitationConverter;
import com.fzf.study.infrastructure.adapter.db.mapper.invitation.CardApplyInvitationMapper;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardApplyInvitationPO;
import com.fzf.study.infrastructure.adapter.db.po.invitation.CardInvitationQueryPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:31
 * @description: 卡片申请邀请Repository-MyBatis实现
 * @version: v1.0
 */
@Repository("cardApplyInvitationRepository")
public class CardApplyInvitationMyBatisRepository
        implements CardApplyInvitationRepository {

    @Resource
    private CardApplyInvitationMapper cardApplyInvitationMapper;

    @Override
    public CardApplyInvitation queryCardApplyInvitationByApplyFlowNo(String appNo) {
        return CardApplyInvitationConverter.convert2CardApplyInvitation(
                cardApplyInvitationMapper.queryCardApplyInvitationByApplyFlowNo(appNo));
    }

    @Override
    public long addCardApplyInvitation(CardApplyInvitation cardApplyInvitation) {
        return cardApplyInvitationMapper.addCardApplyInvitation(CardApplyInvitationConverter
                .convert2CardApplyInvitation(cardApplyInvitation));
    }

    @Override
    public long updateCardApplyInvitationStatusByNotFinalState(CardApply cardApply) {
        return cardApplyInvitationMapper.updateInviteeInfoByApplyIdAndState(CardApplyInvitationConverter.convert2CardApply(cardApply));
    }

    @Override
    public long updateCardApplyInvitationStatus(CardApply cardApply) {
        return cardApplyInvitationMapper.updateInviteeInfoByApplyId(CardApplyInvitationConverter.convert2CardApply(cardApply));
    }

    @Override
    public long updateCardActivationStatus(CardApply cardApply) {
        return cardApplyInvitationMapper.updateCardActivationStatusByCardNo(CardApplyInvitationConverter.convert2ActivationCardApply(cardApply));
    }

    @Override
    public long countCardApplyPassByThreeDay(String inviteeIdNo, List<String> applyStatusList) {
        return cardApplyInvitationMapper.countCardApplyPassByThreeDay(inviteeIdNo, applyStatusList);
    }

    @Override
    public List<CardApplyCount> countInviteeByIdNo(String inviterIdNo, BankEmployeeFlagEnum bankEmployeeFlagEnum) {
        return CardApplyInvitationConverter.convert2CardApplyCount(cardApplyInvitationMapper.countInviteeByIdNo(inviterIdNo, bankEmployeeFlagEnum.getCode()));
    }

    @Override
    public List<CardApplyCount> countInviteeByIdNoAndEmployeeNo(String bankEmployeeNo) {
        return CardApplyInvitationConverter.convert2CardApplyCount(cardApplyInvitationMapper.countInviteeByIdNoAndEmployeeNo(bankEmployeeNo));
    }

    @Override
    public long countInviteeTotal(CardInvitationQuery cardInvitationQuery) {
        List<String> cardStatus=new ArrayList<>();
        for(CardInvitationStatusEnum cardInvitationStatusEnum:cardInvitationQuery.getCardApplyStatus()){
            cardStatus.add(cardInvitationStatusEnum.getCode());

        }
        return cardApplyInvitationMapper.countInviteeTotal(cardInvitationQuery.getInviterIdNo(),
                cardStatus, cardInvitationQuery.getBankEmployeeFlagEnum().getCode(),
                cardInvitationQuery.getInvititationOptEnum().getCode(),
                cardInvitationQuery.getStartDate(),cardInvitationQuery.getEndDate());
    }

    @Override
    public List<CardApplyInvitation> queryCardInvitationByInviterNo(CardInvitationQuery cardInvitationQuery) {
        List<CardApplyInvitation> cardApplyInvitationList = new ArrayList<>();

        //请求内容，转换为数据库请求PO
        CardInvitationQueryPO cardInvitationQueryPO = CardApplyInvitationConverter.
                convert2CardInvitationQuery(cardInvitationQuery);

        //查询结果
        List<CardApplyInvitationPO> cardInvitationQueryPOList = cardApplyInvitationMapper.
                queryCardInvitationByInviterNo(cardInvitationQueryPO);

        //返回转换对象
        for (CardApplyInvitationPO cardApplyInvitationPO : cardInvitationQueryPOList) {
            cardApplyInvitationList.add(CardApplyInvitationConverter.convert2CardApplyInvitation(cardApplyInvitationPO));
        }

        return cardApplyInvitationList;
    }

    @Override
    public long countInviteeTotalByEmployeeNo(CardInvitationQuery cardInvitationQuery) {
        List<String> cardStatus=new ArrayList<>();
        for(CardInvitationStatusEnum cardInvitationStatusEnum:cardInvitationQuery.getCardApplyStatus()){
            cardStatus.add(cardInvitationStatusEnum.getCode());

        }
        return cardApplyInvitationMapper.countInviteeTotalByEmployeeNo(cardInvitationQuery.getBankEmployeeNo(),
                cardStatus,
                cardInvitationQuery.getInvititationOptEnum().getCode());
    }

    @Override
    public List<CardApplyInvitation> queryCardInvitationByEmployeeNo(CardInvitationQuery cardInvitationQuery) {
        List<CardApplyInvitation> cardApplyInvitationList = new ArrayList<>();

        //请求内容，转换为数据库请求PO
        CardInvitationQueryPO cardInvitationQueryPO = CardApplyInvitationConverter.
                convert2CardInvitationQueryByEmployeeNo(cardInvitationQuery);

        //查询结果
        List<CardApplyInvitationPO> cardInvitationQueryPOList = cardApplyInvitationMapper.
                queryCardInvitationByEmployeeNo(cardInvitationQueryPO);

        //返回转换对象
        for (CardApplyInvitationPO cardApplyInvitationPO : cardInvitationQueryPOList) {
            cardApplyInvitationList.add(CardApplyInvitationConverter.convert2CardApplyInvitation(cardApplyInvitationPO));
        }

        return cardApplyInvitationList;
    }

}
