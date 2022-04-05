package com.fzf.study.dictionary.exception;

/**
 * @author: SunKe
 * @date: 2020/9/10 4:17 下午
 * @description: 营销活动异常
 */
public class MktException extends RuntimeException {
    private static final long serialVersionUID = 7004630956593380147L;

    /**
     * 错误码
     */
    private BaseResponseCode errorCode;

    /**
     * 自定义错误描述
     */
    private String message;

    MktException(BaseResponseCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    MktException(BaseResponseCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public BaseResponseCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
