package com.fzf.study.dictionary.exception;

/**
 * @author: zhangheteng
 * @date: 2021-06-24 17:10
 * @description
 */
public class DiscountCouponException extends RuntimeException {

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String message;

    public DiscountCouponException(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
