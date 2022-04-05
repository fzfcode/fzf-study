/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.request;

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
public class CardInvitationCountQueryRequest {

	/**
	 * 邀请人证件号
	 */
	private String inviterNo;

	/**
	 * 是否行员标识
	 */
	private String bankEmployeeFlag;

}
