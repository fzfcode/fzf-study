/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.exception.error.code;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

/**
 * @author: zhujianxun
 * @date: 2020/9/21 2:09 下午
 * @description: 卡片激活邀请活动异常码枚举
 * 异常码段 10601-10700
 */
public enum CardActivationInviteErrorCodeEnum implements BaseResponseCode {

    CLOSEED_LABEL_TYPE(10601, "标签未启用", ErrorLogLevelEnum.INFO),
    REPESAT_SEND_INVALID(10602, "无符合发送条件的用户", ErrorLogLevelEnum.INFO),
    UNMATCH_LABEL_TYPE(10603, "标签不匹配", ErrorLogLevelEnum.INFO),
    EMPTY_SMS_CONTENT(10604, "短信模版为空", ErrorLogLevelEnum.INFO),
    ACQUIRE_LOCK_FAILED(10605, "超过用户发送短信限制", ErrorLogLevelEnum.INFO),
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

    CardActivationInviteErrorCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
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

    @Override
    public String toString() {
        return "CardActivationInviteErrorCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", errorLevel=" + errorLogLevel +
                '}';
    }
}
