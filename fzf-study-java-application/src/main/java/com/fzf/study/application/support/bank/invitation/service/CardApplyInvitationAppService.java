/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.service;

import com.fzf.study.application.support.bank.invitation.builder.CardApplyInvitationBuilder;
import com.fzf.study.application.support.bank.invitation.checker.CardApplyInvitationBizChecker;
import com.fzf.study.application.support.bank.invitation.request.CardActivationUpdateRequest;
import com.fzf.study.application.support.bank.invitation.request.CardApplyInvitationAddRequest;
import com.fzf.study.application.support.bank.invitation.request.CardApplyInvitationUpdateRequest;
import com.fzf.study.application.support.bank.invitation.retry.CardApplyInvitationRetryService;
import com.fzf.study.dictionary.enums.CardInvitationDegreeEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
import com.fzf.study.domain.common.MetricMonitor;
import com.fzf.study.domain.common.model.Customer;
import com.fzf.study.domain.common.repository.AccountRepository;
import com.fzf.study.domain.common.repository.CustomerRepository;
import com.fzf.study.domain.support.bank.invitation.model.CardApply;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyInvitation;
import com.fzf.study.domain.support.bank.invitation.model.Inviter;
import com.fzf.study.domain.support.bank.invitation.repository.CardApplyInvitationRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/10 14:51
 * @description: 小程序二维码邀请办卡应用服务
 * @version: v1.0
 */
@Slf4j
@Service
public class CardApplyInvitationAppService {

    @Resource
    private CardApplyInvitationBizChecker bizChecker;

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private CardApplyInvitationRepository cardApplyInvitationRepository;

    @Resource
    private AccountRepository accountRepository;

    @Resource
    private CardApplyInvitationRetryService retryService;

    @Resource
    private MetricMonitor metricMonitor;

    //销户状态
    private static final String CLOSE_BLOCK_CODE = "P";

    /**
     * 新增邀请办卡进件信息
     *
     * @param addInfo 卡片进件请求信息
     * @return 卡片进件Id
     */
    public void addCardApplyInvitation(CardApplyInvitationAddRequest addInfo) {
        //业务校验
        bizChecker.checkCardApplyAddRequest(addInfo);

        //补充邀请人信息
        Inviter inviter = supplementInviter(addInfo.getReferrerInfo());

        //获取卡片新旧户最终标识
        CardInvitationDegreeEnum cardInvitationDegreeEnum = getProcessCardDegree(
                CardInvitationDegreeEnum.getSearchOptByCode(addInfo.getAcctCustTypeIdentify()),
                addInfo.getIdNo());

        //邀请办卡信息聚合对象
        CardApplyInvitation cardApplyInvitation = CardApplyInvitationBuilder.build(inviter, addInfo, cardInvitationDegreeEnum);

        //新增进件信息
        cardApplyInvitationRepository.addCardApplyInvitation(cardApplyInvitation);

        metricMonitor.logMetricForCount("邀请办卡新增办卡进件成功数量");
    }

    /**
     * 更新邀请办卡进件审批状态
     *
     * @param updateInfo 卡片进件更新信息
     */
    public void updateCardApplyInvitationStatus(CardApplyInvitationUpdateRequest updateInfo) {
        //活动校验
        bizChecker.checkActivity();

        //更新状态前获取卡片邀请记录，若无记录，进行重试
        CardApplyInvitation cardApplyInvitation = retryService.retryQueryCardStatus(updateInfo.getApplyFlowNo());

        //获取卡片新旧户最终标识
        CardInvitationDegreeEnum cardInvitationDegreeEnum = getProcessCardDegree(
                cardApplyInvitation.getCardApply().getCardInvitationDegreeEnum(),
                cardApplyInvitation.getInvitee().getInviteeIdNo());

        //被邀请人信息聚合对象
        CardApply cardApply = CardApplyInvitationBuilder.buildCardApply(updateInfo, cardInvitationDegreeEnum);

        //更新被邀请人进件信息
        if (cardApply.getCardStatus() == CardInvitationStatusEnum.APS_ACCEPTED ||
                cardApply.getCardStatus() == CardInvitationStatusEnum.APS_REJECTED ||
                cardApply.getCardStatus() == CardInvitationStatusEnum.APS_DISCARD) {
            cardApplyInvitationRepository.updateCardApplyInvitationStatus(cardApply);
            return;
        }
        cardApplyInvitationRepository.updateCardApplyInvitationStatusByNotFinalState(cardApply);

        metricMonitor.logMetricForCount("邀请办卡更新邀请件状态成功数量");
    }

    /**
     * 更新邀请办卡卡片激活状态
     *
     * @param updateInfo 卡片激活更新信息
     * @return 卡片激活更新Id
     */
    public void updateCardActivationInvitationStatus(CardActivationUpdateRequest updateInfo) {
        //活动校验
        bizChecker.checkActivity();

        //卡片申请信息聚合对象
        CardApply cardApply = CardApplyInvitationBuilder.buildActivationCardApply(updateInfo);

        //更新被邀请人进件信息
        cardApplyInvitationRepository.updateCardActivationStatus(cardApply);
        metricMonitor.logMetricForCount("邀请办卡激活消息成功数量");
    }

    /**
     * 补充申请进件邀请人信息
     *
     * @param inviterCustomerNo 邀请人客户号
     * @return 邀请办卡信息聚合对象
     */
    public Inviter supplementInviter(String inviterCustomerNo) {

        if (StringUtils.isNotBlank(inviterCustomerNo)) {
            long customerNo = Long.parseLong(inviterCustomerNo);
            Customer customer = customerRepository.queryCustomerByCustomerNo(customerNo);
            if (customer != null) {
                return Inviter.builder()
                        .inviterCustomerNo(customerNo)
                        .inviterIdNo(customer.getIdNo())
                        .inviterName(customer.getCustomerName())
                        .build();
            }
        }
        return Inviter.builder().build();
    }


    /**
     * 获取卡片新旧户最终标识
     * 1.新户进件，查询近3天有无审批通过的卡片，若有通过卡片，后续进件置为旧户
     * 2.旧户进件，查询当前用户所有账户是否为销户状态，若销户则置为新户
     *
     * @param degreeEnum  新旧户标识
     * @param inviteeIdNo 被邀请人证件号
     * @return 新旧户标识
     */
    private CardInvitationDegreeEnum getProcessCardDegree(CardInvitationDegreeEnum degreeEnum, String inviteeIdNo) {
        if (degreeEnum.equals(CardInvitationDegreeEnum.NEW)) {
            return processCardDegreeNew(inviteeIdNo);
        } else {
            return processCardDegreeOld(inviteeIdNo);
        }
    }

    /**
     * 进件为新户标识时
     * 新户进件，查询近3天有无审批通过的卡片，若有通过卡片，后续进件置为旧户
     *
     * @param inviteeIdNo 被邀请人证件号
     * @return 新旧户标识
     */
    private CardInvitationDegreeEnum processCardDegreeNew(String inviteeIdNo) {

        //查询被邀请人信息最近3天卡片数量
        long cardCount = cardApplyInvitationRepository.countCardApplyPassByThreeDay(inviteeIdNo, Arrays.asList(CardInvitationStatusEnum.APS_ACCEPTED.getCode(),
                CardInvitationStatusEnum.CARD_ACTIVATED.getCode()));

        return cardCount > 0 ? CardInvitationDegreeEnum.OLD : CardInvitationDegreeEnum.NEW;

    }

    /**
     * 进件为旧户标识时
     * 旧户进件，查询当前用户所有账户是否为销户状态，若销户则置为新户
     *
     * @param inviteeIdNo 被邀请人证件号
     * @return 新旧户标识
     */
    private CardInvitationDegreeEnum processCardDegreeOld(String inviteeIdNo) {
        boolean acctStatusClosed = true;

        //查询证件号的所有账户状态
        List<String> blockCodeList = accountRepository.queryAccountBlockCodeByIdNo(inviteeIdNo);
        for (String blockCode : blockCodeList) {
            if (!blockCode.contains(CLOSE_BLOCK_CODE)) {
                acctStatusClosed = false;
                break;
            }
        }

        //所有账户都为销户状态时，则视为新户处理
        if (acctStatusClosed) {
            return processCardDegreeNew(inviteeIdNo);
        }

        return CardInvitationDegreeEnum.OLD;
    }

}
