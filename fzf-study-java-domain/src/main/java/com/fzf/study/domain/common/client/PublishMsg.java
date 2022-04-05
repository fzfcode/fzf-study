/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.client;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 5:58 下午
 * @description: 推送消息
 */
@Getter
@Setter
public class PublishMsg {
    /**
     * 消息类型
     */
    private String messageType;
    /**
     * 消息内容
     */
    private String message;
}
