package com.fzf.study.dictionary.exception;


import com.fzf.study.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.fzf.study.dictionary.exception.error.code.InstalmentDiscountErrorCodeEnum;

/**
 * @author: SunKe
 * @date: 2020/9/10 4:20 下午
 * @description: 错误码
 * 系统异常码段 9000-10000 {@link CommonResponseCodeEnum}
 * 公用异常码段 10001-10500 {@link CommonResponseCodeEnum}
 * 分期折扣活动 10501-10600 {@link InstalmentDiscountErrorCodeEnum}
 */
public interface BaseResponseCode {

    /**
     * 查询错误码
     * @return 错误码
     */
    int getCode();

    /**
     * 查询错误描述
     * @return 错误描述
     */
    String getMessage();

    /**
     * 查询错误打印日志级别
     * @return 错误打印日志级别
     */
    ErrorLogLevelEnum getErrorLogLevel();
}
