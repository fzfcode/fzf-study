package com.fzf.study.dictionary.exception.error.code;

import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.INFO;


/**
 * @author: SunKe
 * @date: 2020/9/11 2:13 下午
 * @description: 分期折扣活动异常码枚举
 * 异常码段 10501-10600
 */
public enum InstalmentDiscountErrorCodeEnum implements BaseResponseCode {
    /**
     * 活动优先级冲突
     */
    PRIORITY_CONFLICT(10501, "活动优先级冲突", INFO),

    /**
     * 超出单次上传白名单上限
     */
    WHITELIST_SINGLE_NUM_EXCEED(10502, "超出单次上传白名单上限", INFO),

    /**
     * 超出单次上传白名单上限
     */
    WHITELIST_TOTAL_NUM_EXCEED(10503, "超出上传白名单总上限", INFO),

    /**
     * 无分期期数对应折扣优惠
     */
    INSTALMENT_TERM_PREFERENTIAL_NOT_EXIST(10504, "无分期期数对应折扣优惠", INFO),
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

    InstalmentDiscountErrorCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
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
