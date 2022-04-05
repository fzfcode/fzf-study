/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.response;

import com.fzf.study.rpc.adapter.socket.annotation.RespXmlElement;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/10/19 20:29
 * @description: 活动报名信息查询Socket返回信息
 * @version: v1.0
 */
@RespXmlElement(elementName = "")
@Data
public class ActivitySignUpQuerySocketResponse {

    /**
     * 活动报名状态
     */
    @RespXmlElement(elementName = "SIGN_UP_STATUS")
    private Integer signUpStatus;

    /**
     * 活动报名渠道
     */
    @RespXmlElement(elementName = "ACTIVITY_CHANNEL")
    private String activityChannel;

    /**
     * 活动识别码
     */
    @RespXmlElement(elementName = "ACTIVITY_CODE")
    private String activityCode;

    /**
     * 活动报名时间
     */
    @RespXmlElement(elementName = "SIGN_UP_TIME")
    private String signUpTime;

    /**
     * 扩展信息
     */
    @RespXmlElement(elementName = "EXTEND_CONTENT")
    private String extendContent;
}
