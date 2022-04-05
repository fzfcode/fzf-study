/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: HouGang
 * @date: 2021-04-25 10:37:40
 * @description: 配置字典
 */
@Data
@Builder
public class MktDict {
    /**
     * 字典ID
     */
    private Integer id;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典KEY
     */
    private String dictKey;

    /**
     * 字典内容
     */
    private String dictValue;

    /**
     * 字典描述
     */
    private String dictDesc;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
