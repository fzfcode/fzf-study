/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author: HouGang
 * @date: 2020/9/12 15:18
 * @description: 客户信息
 * @version: v1.0
 */

@SuperBuilder
@Data
public class Customer {

	/**
	 * 客户号
	 */
	private Integer customerNo;

	/**
	 * 客户姓名
	 */
	private String customerName;

	/**
	 * 证件类型
	 */
	private String idType;

	/**
	 * 证件号
	 */
	private String idNo;

	/**
	 * 手机号
	 */
	private String mobileNo;

}
