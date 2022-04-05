/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.application.support.bank.invitation.request;

import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/12 14:02
 * @description: 新增邀请办卡请求信息
 * @version: v1.0
 */
@Data
public class CardApplyInvitationAddRequest {

	//-----------------------被邀请人信息Begin------------------------
	/**
	 * 审批流水号
	 */
	private String appNo;

	/**
	 * 申请流水号
	 */
	private String applyFlowNo;

	/**
	 * 申请人姓名
	 */
	private String name;

	/**
	 * 申请卡号
	 */
	private String cardNo;

	/**
	 * 申请人手机号
	 */
	private String cellPhone;

	/**
	 * 申请人身份证号
	 */
	private String idNo;

	/**
	 * 申请人申请时间
	 */
	private String applyTime;

	/**
	 * 产品类型
	 */
	private String productCd;

	/**
	 * 新旧户标识
	 */
	private String acctCustTypeIdentify;

	//-----------------------被邀请人信息End------------------------


	//-----------------------邀请人信息Begin------------------------
	/**
	 * 推荐人工号
	 */
	private String recomenderId;

	/**
	 * 推荐人网点号
	 */
	private String recomenderBankBranch;

	/**
	 * 团办信息JSON
	 */
	private String groupInfo;

	/**
	 * 推荐人信息JSON
	 */
	private String referrerInfo;
	//-----------------------邀请人信息End------------------------

}
