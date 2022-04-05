/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.dictionary.exception.error.code;

import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;
import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 11:34 上午
 * @description:
 */
@Getter
public enum SmsTemplateErrorCodeEnum implements BaseResponseCode {
    QUERY_SMS_ERROR(20001, "查询短信列表系统异常"),
    UPDATE_SMS_ERROR(20002, "更新短信模板系统异常"),
    ADD_SMS_ERROR(20003, "新增短信模板系统异常"),
    SMS_ID_NOT_BANK(20004, "短信模板ID不可为空"),
    SMS_CONTENT_NOT_BANK(20005, "短信模板内容不可为空"),
    SMS_REMARK_NOT_BANK(20006, "备注不可为空"),
    SMS_NAME_NOT_BANK(20007, "短信模板名称不可为空");

    SmsTemplateErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String msg;

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public ErrorLogLevelEnum getErrorLogLevel() {
        return ErrorLogLevelEnum.INFO;
    }
}
