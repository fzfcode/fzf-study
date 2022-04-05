/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.response;

import com.fzf.study.rpc.adapter.socket.annotation.RespXmlElement;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020-09-14 22:01:00
 * @description: 邀请办卡数量查询Socket返回参数
 * @version: v1.0
 */
@Data
@RespXmlElement(elementName = "")
public class CardInvitationCountSocketResponse {

    /**
     * 邀请人证件号
     */
    @RespXmlElement(elementName = "ID_NO")
    private String inviterNo;

    /**
     * 邀请办卡卡片数量
     */
    @RespXmlElement(elementName = "APPLY_COUNT")
    private long applyCount;

    /**
     * 邀请办卡审批通过数量
     */
    @RespXmlElement(elementName = "ACCEPTED_COUNT")
    private long acceptedCount;

    /**
     * 邀请办卡激活数量
     */
    @RespXmlElement(elementName = "ACTIVATED_COUNT")
    private long activatedCount;

    /**
     * 邀请办卡未激活数量
     */
    @RespXmlElement(elementName = "NO_ACTIVATED_COUNT")
    private long notActivatedCount;

}
