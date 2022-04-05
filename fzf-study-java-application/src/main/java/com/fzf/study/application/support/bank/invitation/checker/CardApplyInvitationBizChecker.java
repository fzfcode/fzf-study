/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.checker;

import com.fzf.study.application.support.bank.invitation.request.CardApplyInvitationAddRequest;
import com.fzf.study.dictionary.enums.ExternalActivityTypeEnum;
import com.fzf.study.dictionary.exception.error.code.CardInvitationErrorCodeEnum;
import com.fzf.study.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.fzf.study.domain.common.ExternalActivity;
import com.fzf.study.domain.common.ExternalActivityRepository;
import com.fzf.study.domain.common.MktActivityAssertUtils;
import com.fzf.study.domain.support.bank.invitation.model.CardApplyInvitation;
import com.fzf.study.domain.support.bank.invitation.repository.CardApplyInvitationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author: HouGang
 * @date: 2020/9/10 14:52
 * @description: 邀请办卡业务校验
 * @version: v1.0
 */

@Component
public class CardApplyInvitationBizChecker {

    @Resource
    CardApplyInvitationRepository cardApplyInvitationRepository;

    @Resource
    private ExternalActivityRepository externalActivityRepository;

    public void checkCardApplyAddRequest(CardApplyInvitationAddRequest addRequest) {

        //校验活动是否存在
        checkActivity();

        //邀请人客户号或邀请行号必须存在其一
        MktActivityAssertUtils.assertTrue(StringUtils.isNotBlank(addRequest.getReferrerInfo()) ||
                StringUtils.isNotBlank(addRequest.getRecomenderId()), CardInvitationErrorCodeEnum.CUST_NO_OR_BANK_EMPLOYEE_NO_NOT_NULL);

        //幂等校验
        CardApplyInvitation cardApplyInvitation = cardApplyInvitationRepository.queryCardApplyInvitationByApplyFlowNo(addRequest.getApplyFlowNo());

        MktActivityAssertUtils.assertTrue(Objects.isNull(cardApplyInvitation), CardInvitationErrorCodeEnum.APPLY_NO_EXIST);

    }

    /**
     * 校验外部活动是否存在
     */
    public void checkActivity() {
        //校验活动是否存在
        ExternalActivity mktExternalActivity = externalActivityRepository.queryByType(ExternalActivityTypeEnum.QD_CARD_INVITATION.getActivityType());

        MktActivityAssertUtils.assertNotNull(mktExternalActivity, CommonResponseCodeEnum.ACTIVITY_NOT_EXIST);
    }

}
