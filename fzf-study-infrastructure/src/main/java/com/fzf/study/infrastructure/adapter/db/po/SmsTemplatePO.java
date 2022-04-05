/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/10/9 12:03 下午
 * @description: 短信模版
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SmsTemplatePO {
    /**
     * id
     */
    private Integer id;
    /**
     * 短信ID
     */
    private Integer smsId;
    /**
     * 内容
     */
    private String content;
    /**
     * 模版名称
     */
    private String templateName;
    /**
     * 发送开始时间
     */
    private String sendBeginTime;
    /**
     * 发送截止时间
     */
    private String sendEndTime;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
