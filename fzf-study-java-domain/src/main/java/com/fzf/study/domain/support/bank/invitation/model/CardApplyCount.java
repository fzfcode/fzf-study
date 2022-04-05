/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.model;

import com.fzf.study.dictionary.enums.CardInvitationStatusEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:33
 * @description: 邀请办卡PO
 * @version: v1.0
 */
@Builder
@Data
public class CardApplyCount {

	/**
	 * 申请状态
	 */
	private CardInvitationStatusEnum applyStatus;

	/**
	 * 申请数量
	 */
	private Integer applyCount;
}
