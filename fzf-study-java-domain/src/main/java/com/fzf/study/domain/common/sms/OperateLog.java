/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.sms;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 11:59 上午
 * @description:
 */
@Getter
@Setter
public class OperateLog {
    private Long id;

    private String operator;

    private String content;

    private Date createTime;

    private String remark;
}
