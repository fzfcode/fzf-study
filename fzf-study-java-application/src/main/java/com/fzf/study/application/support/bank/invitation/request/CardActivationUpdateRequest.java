/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.request;

import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/12 14:02
 * @description: 邀请办卡卡片激活更新信息
 * @version: v1.0
 */
@Data
public class CardActivationUpdateRequest {

	/**
	 * 申请卡号
	 */
	private String cardNo;

	/**
	 * 卡片激活时间
	 */
	private String cardActivationTime;

}
