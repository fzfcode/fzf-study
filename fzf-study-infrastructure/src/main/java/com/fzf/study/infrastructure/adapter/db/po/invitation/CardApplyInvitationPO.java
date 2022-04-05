/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po.invitation;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:33
 * @description: 邀请办卡PO
 * @version: v1.0
 */
@Builder
@Data
public class CardApplyInvitationPO {

	/**
	 * 卡片申请id
	 */
	private Integer id;

	/**
	 * 审批号
	 */
	private String applyId;

	/**
	 * 机构号
	 */
	private String orgCode;

	/**
	 * 被邀请人姓名
	 */
	private String inviteeName;

	/**
	 * 邀请人姓名
	 */
	private String inviterName;

	/**
	 * 卡产品类型
	 */
	private String prodCd;

	/**
	 * 被邀请人手机号
	 */
	private String inviteePhone;

	/**
	 * 邀请人手机号
	 */
	private String inviterPhone;

	/**
	 * 被邀请证件号
	 */
	private String inviteeIdNo;

	/**
	 * 邀请人证件号
	 */
	private String inviterIdNo;

	/**
	 * 邀请人客户号
	 */
	private Long inviterCustId;

	/**
	 * 申请时间
	 */
	private String applyTime;

	/**
	 * 申请状态
	 */
	private String applyStatus;

	/**
	 * 审批通过时间
	 */
	private String apsPassTime;

	/**
	 * 卡片激活时间
	 */
	private String cardActivTime;

	/**
	 * 卡号
	 */
	private String cardNo;

	/**
	 * 邀请人员工编号
	 */
	private String inviterJobNo;

	/**
	 * 邀请人网点编号
	 */
	private String inviterBranchNo;

	/**
	 * 邀请人网点级别
	 */
	private String intiterBranchLevel;

	/**
	 * 邀请人级别
	 */
	private String inviterLevel;

	/**
	 * 行员岗位
	 */
	private String inviterPosition;

	/**
	 * 优质企业编号
	 */
	private String goodComCode;

	/**
	 * 企业名称
	 */
	private String goodComName;

	/**
	 * 企业简称
	 */
	private String goodComShort;

	/**
	 * 新旧户标识
	 */
	private String acctCustIdentify;

	/**
	 * 创建时间
	 */
	private Date addTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;
}
