/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po.invitation;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020-09-15 19:53:23
 * @description: 邀请办卡查询PO
 * @version: v1.0
 */
@Builder
@Data
public class CardInvitationQueryPO {

	/**
	 * 邀请人证件号
	 */
	private String inviterIdNo;

	/**
	 * 行员编号
	 */
	private String bankEmployeeNo;

	/**
	 * 卡片申请状态
	 */
	private List<String> cardApplyStatusList;

	/**
	 * 是否行员标识
	 */
	private String bankEmployeeFlag;

	/**
	 * 邀请性质 个人/公司
	 */
	private String invititationOpt;

	/**
	 * 开始行数
	 */
	private long firstRow;

	/**
	 * 结束行数
	 */
	private long lastRow;

	/**
	 * 开始日期
	 */
	private Date startDate;

	/**
	 * 结束日期
	 */
	private Date endDate;
}
