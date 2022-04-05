/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.sms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 10:16 上午
 * @description:
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SmsTemplate {
    private Integer id;

    private Integer smsId;

    private String content;

    private String templateName;

    private String sendBeginTime;

    private String sendEndTime;

    private Date addTime;

    private Date updateTime;
}
