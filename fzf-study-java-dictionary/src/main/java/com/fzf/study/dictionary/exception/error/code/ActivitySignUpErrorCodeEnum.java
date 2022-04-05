/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.exception.error.code;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.INFO;


/**
 * @author: HouGang
 * @date: 2020/10/19 16:39
 * @description: 活动报名异常码枚举
 * @version: v1.0
 * 异常码段 10701-10800
 *
 */
public enum ActivitySignUpErrorCodeEnum implements BaseResponseCode {

    /**
     * 报名号类型有误
     */
    ACTIVITY_SIGN_UP_MEMBER_TYPE_ERROR(10701, "活动指定活动报名号类型有误", INFO),

    /**
     * 报名渠道有误
     */
    ACTIVITY_SIGN_UP_CHANNEL_ERROR(10702, "活动报名渠道有误", INFO),

    /**
     * 活动报名时间已截止
     */
    ACTIVITY_SIGN_UP_TIME_DEAD(10703, "活动报名时间已截止", INFO),

    /**
     * 请勿重复成功
     */
    ACTIVITY_SIGN_UP_REPETITION_ERROR(10704, "请勿重复报名活动", INFO),

    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 错误级别
     */
    private ErrorLogLevelEnum errorLogLevel;

    ActivitySignUpErrorCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
        this.code = code;
        this.msg = msg;
        this.errorLogLevel = errorLogLevel;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public ErrorLogLevelEnum getErrorLogLevel() {
        return errorLogLevel;
    }

}
