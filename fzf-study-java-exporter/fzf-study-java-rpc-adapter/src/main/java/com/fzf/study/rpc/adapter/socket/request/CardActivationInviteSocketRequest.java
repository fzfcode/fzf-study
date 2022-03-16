/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 10:47 上午
 * @description: 卡片激活邀请SocketRequest
 */
@Builder
@Getter
public class CardActivationInviteSocketRequest {
    /**
     * 流水号
     */
    private String serviceSn;
    /**
     * 申请编号
     */
    private List<String> applyNos;
    /**
     * 标签类型
     */
    private String labelType;
    /**
     * 发送类型
     */
    private String sendType;
}
