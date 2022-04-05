package com.fzf.study.dictionary.exception.error.code;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 4:50 下午
 * @description:
 */
public enum ActiveLabelErrorCodeEnum implements BaseResponseCode {

    QUERY_ACTIVE_LABEL_ERROR(20021, "查询激活标签列表系统异常"),
    UPDATE_ACTIVE_LABEL_ERROR(20022, "更新激活标签系统异常"),
    ADD_ACTIVE_LABEL_ERROR(20023, "新增激活标签系统异常"),
    SMS_ID_NOT_NULL(20024, "短信模板ID不可为空"),
    ACTIVE_LABEL_NOT_NULL(20025, "激活标签不可为空"),
    ACTIVE_REMARK_NOT_NULL(20026, "备注不可为空"),
    LABEL_SENDTYPE_NOT_NULL(20027, "标签发送类别有误"),
    LABEL_UPFLAG_NOT_NULL(20028, "标签上下行标识有误"),
    LABEL_STATUS_NOT_NULL(20029, "标签状态有误"),
    LABEL_REPLAY_NOT_NULL(20030, "回复标识不可为空"),
    LABEL_DESC_NOT_NULL(20031, "标签描述不可为空");

    ActiveLabelErrorCodeEnum(int code, String msg) {
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
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public ErrorLogLevelEnum getErrorLogLevel() {
        return ErrorLogLevelEnum.INFO;
    }
}
