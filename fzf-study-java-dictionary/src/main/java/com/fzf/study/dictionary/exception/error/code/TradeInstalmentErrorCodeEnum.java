package com.fzf.study.dictionary.exception.error.code;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.INFO;


/**
 * @author: xuaimin
 * @date: 2020/10/14 下午2:36
 * @description: 消费分期异常枚举
 */
public enum TradeInstalmentErrorCodeEnum implements BaseResponseCode {


    CONSUME_LOAN_ACTIVITY_IS_NOT_USED(10900, "消费分期活动没有上架", INFO),
    /**
     * 该账户不在白名单
     */
    ACCOUNT_NOT_IN_WHITELIST(10901, "该账户不在白名单内", INFO),

    CHB_AMT_LT_LOWEST_LOAN_AMT(10902, "入账金额小于最低可分期金额", INFO),

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

    TradeInstalmentErrorCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
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
        return "consumeLoanErrorCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", errorLevel=" + errorLogLevel +
                '}';
    }

}
