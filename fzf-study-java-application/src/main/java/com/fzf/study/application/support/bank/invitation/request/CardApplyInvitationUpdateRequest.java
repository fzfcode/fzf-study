/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.request;

import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/12 14:02
 * @description: 邀请办卡更新信息
 * @version: v1.0
 */
@Data
public class CardApplyInvitationUpdateRequest {

	/**
	 * 申请流水号
	 */
	private String applyFlowNo;

	/**
	 * 申请卡号
	 */
	private String cardNo;

	/**
	 * 审批通过时间
	 */
	private String approveTime;

	/**
	 * 进件消息类型
	 */
	private String messageType;



}
