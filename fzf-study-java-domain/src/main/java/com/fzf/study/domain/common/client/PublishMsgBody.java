/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.client;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 5:59 下午
 * @description: 推送消息body
 */
@Getter
@Setter
public class PublishMsgBody {
    /**
     * 申请编号
     */
    private String applyNo;
    /**
     * 服务类型
     */
    private String serviceType;
    /**
     * 操作类型
     */
    private String optType;
    /**
     * 银行ID
     */
    private String bankId;
}
