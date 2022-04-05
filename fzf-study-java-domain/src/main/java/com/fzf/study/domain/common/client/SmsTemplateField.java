/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.client;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


/**
 * @author: zhujianxun
 * @date: 2020/9/22 3:50 下午
 * @description: 活动短信变量
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class SmsTemplateField {
    /**
     * 姓名
     */
    private String name;
}
