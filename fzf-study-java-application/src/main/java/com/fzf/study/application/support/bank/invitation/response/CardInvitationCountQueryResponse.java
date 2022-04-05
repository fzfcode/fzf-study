/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询
 * @version: v1.0
 */
@Data
@Builder
public class CardInvitationCountQueryResponse {

	/**
	 * 邀请人证件号
	 */
	private String inviterNo;

	/**
	 * 邀请办卡卡片数量
	 */
	private long applyCount;

	/**
	 * 邀请办卡审批通过数量
	 */
	private long acceptedCount;

	/**
	 * 邀请办卡激活数量
	 */
	private long activatedCount;

	/**
	 * 邀请办卡未激活数量
	 */
	private long notActivatedCount;

}
