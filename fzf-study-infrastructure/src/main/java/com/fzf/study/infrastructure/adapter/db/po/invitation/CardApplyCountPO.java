/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po.invitation;

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
public class CardApplyCountPO {

	/**
	 * 申请状态
	 */
	private String applyStatus;

	/**
	 * 卡片数量
	 */
	private Integer applyCount;
}
