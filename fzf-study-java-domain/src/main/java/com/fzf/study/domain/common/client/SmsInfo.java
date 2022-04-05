/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.client;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/22 4:30 下午
 * @description: 短信报文DTO
 */
@Builder
@Getter
public class SmsInfo {
    /**
     * 机构号
     */
    private String org;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 发送方式 实时/批量
     */
    private String sendingWay;
    /**
     * msgCd标识
     */
    private String msgCd;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 短信内容
     */
    private String msgContent;
    /**
     * 操作人
     */
    private String optUser;
}
