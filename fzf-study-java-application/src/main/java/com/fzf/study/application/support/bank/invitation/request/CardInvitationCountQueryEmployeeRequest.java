/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.request;

import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询
 * @version: v1.0
 */
@Data
public class CardInvitationCountQueryEmployeeRequest {

	/**
	 * 行员编号
	 */
	private String bankEmployeeNo;

}
