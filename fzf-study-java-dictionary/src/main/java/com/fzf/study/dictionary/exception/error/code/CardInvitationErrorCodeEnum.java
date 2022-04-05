package com.fzf.study.dictionary.exception.error.code;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.INFO;


/**
 * @author: Hougang
 * @date: 2020-09-19 15:45:33
 * @description: 小程序邀请办卡异常码枚举
 * 异常码段 10601-10700
 */
public enum CardInvitationErrorCodeEnum implements BaseResponseCode {
    /**
     * 申请件已存在
     */
    APPLY_NO_EXIST(10601, "申请件已存在", INFO),
    /**
     * 查询邀请办卡状态失败重试
     */
    RETRY_QUERY_CARD_STATUS_QUERY_ERROR(10602, "查询邀请办卡状态失败重试失败", INFO),
    /**
     * 邀请办卡申请进件类型错误
     */
    CARD_INVITATION_ERROR_CODE_ENUM(10603, "邀请办卡申请进件类型错误", INFO),
    /**
     * 邀请人客户号或行员编号必须存在其一
     */
    CUST_NO_OR_BANK_EMPLOYEE_NO_NOT_NULL(10604, "邀请人客户号或行员编号必须存在其一", INFO),
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

    CardInvitationErrorCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
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
        return "InstalmentDiscountErrorCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", errorLevel=" + errorLogLevel +
                '}';
    }
}
