/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.request;

import lombok.Data;

import java.util.Date;

/**
 * @author: HouGang
 * @date: 2020-09-15 14:36:20
 * @description: 邀请卡片明细查询请求参数
 * @version: v1.0
 */
@Data
public class CardInvitationInfoQueryRequest {

	/**
	 * 邀请人证件号
	 */
	private String inviterNo;

	/**
	 * 是否行员标识
	 */
	private String bankEmployeeFlag;

	/**
	 * 查询状态
	 */
	private String cardStatus;

	/**
	 * 个人/团办邀请查询
	 */
	private String searchType;

	/**
	 * 行员编号
	 */
	private String bankEmployeeNo;

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
