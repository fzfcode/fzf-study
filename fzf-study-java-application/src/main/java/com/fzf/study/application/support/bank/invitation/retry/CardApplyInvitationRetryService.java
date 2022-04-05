/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.retry;

import com.fzf.study.dictionary.exception.MktExceptionBuilder;
import com.fzf.study.dictionary.exception.error.code.CardInvitationErrorCodeEnum;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyInvitation;
import com.fzf.study.domain.support.bank.invitation.repository.CardApplyInvitationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: HouGang
 * @date: 2020/9/10 14:51
 * @description: 小程序二维码邀请重试服务
 * @version: v1.0
 */
@Slf4j
@Service
public class CardApplyInvitationRetryService {


    @Resource
    private CardApplyInvitationRepository cardApplyInvitationRepository;


    /**
     * 更新状态前获取卡片邀请记录，若无记录，进行重试
     *
     * @param applyNo 申请号
     * @return 邀请记录信息
     */
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public CardApplyInvitation retryQueryCardStatus(String applyNo) {

        CardApplyInvitation cardApplyInvitation = cardApplyInvitationRepository.queryCardApplyInvitationByApplyFlowNo(applyNo);
        if (cardApplyInvitation == null) {
            log.info("未查询到要更新状态的申请记录,开始重试,申请号:" + applyNo);
            throw MktExceptionBuilder.build(CardInvitationErrorCodeEnum.RETRY_QUERY_CARD_STATUS_QUERY_ERROR);
        }
        return cardApplyInvitation;
    }

}
