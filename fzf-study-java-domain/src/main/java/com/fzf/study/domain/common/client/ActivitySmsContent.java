/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.client;

import lombok.Builder;
import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2020/9/22 11:35 上午
 * @description: 活动短信内容
 */
@Builder
@Getter
//@DesensitizedMark
public class ActivitySmsContent {
    /**
     * 机构号
     */
    private String org;
    /**
     * msgCd
     */
    private String msgCd;
    /**
     * 短信内容
     */
    private String smsContent;
    /**
     * 手机号
     */
//	@Desensitized(DesensitizedType.MOBILE_NO)
    private String mobileNo;
    /**
     * 日志Key
     */
    private String logKey;
    /**
     * 日志value
     */
    private String logValue;
    /**
     * 是否使用营销短信通道
     */
    private boolean marketingChannelSms;

	/**
	 * 规则名称
	 */
	private String ruleName;

	/**
	 * 标签类型
	 */
	private String labelType;
}
