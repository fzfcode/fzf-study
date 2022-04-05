/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

/**
 * @author: zhujianxun
 * @date: 2020/9/27 9:40 下午
 * @description: 短信模版属性PO
 */
@Builder
@Data
public class SmsTemplateFieldPO {
    /**
     * 姓名
     */
    private String name;
}
