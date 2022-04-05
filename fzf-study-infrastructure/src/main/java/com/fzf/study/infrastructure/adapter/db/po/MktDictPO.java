/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Data;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/29 10:52 上午
 * @description: 配置字典PO
 */
@Data
public class MktDictPO {
    private Integer id;

    private String dictType;

    private String dictKey;

    private String dictValue;

    private String dictDesc;

    private Date addTime;

    private Date updateTime;
}
