/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.client;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 4:38 下午
 * @description: 上行短信日志
 */
@Builder
@Getter
@EqualsAndHashCode
public class UmsSmsLog {
    /**
     * 主键
     */
    private Long id;
    /**
     * 机构号
     */
    private String org;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
}
