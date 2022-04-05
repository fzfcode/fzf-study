/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.exception;


import com.fzf.study.dictionary.exception.error.code.SmsSendErrorCodeEnum;

/**
 * @author: zhujianxun
 * @date: 2020/9/22 5:39 下午
 * @description: 发送短信异常
 */
public class SendSmsException extends Exception{

    private SmsSendErrorCodeEnum errorType;

    public SmsSendErrorCodeEnum getErrorType() {
        return errorType;
    }

    public void setErrorType(SmsSendErrorCodeEnum errorType) {
        this.errorType = errorType;
    }

    public SendSmsException(SmsSendErrorCodeEnum errorType, Throwable cause) {
        super(cause);
        this.errorType = errorType;
    }
    public SendSmsException(SmsSendErrorCodeEnum errorType) {
        super(errorType.getDesc());
    }

}
