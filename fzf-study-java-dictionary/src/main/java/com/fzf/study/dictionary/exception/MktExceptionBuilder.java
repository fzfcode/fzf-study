package com.fzf.study.dictionary.exception;

/**
 * @author: SunKe
 * @date: 2020/9/10 4:37 下午
 * @description: 异常构造器
 */
public class MktExceptionBuilder {

    public static MktException build(BaseResponseCode errorCode) {
        return new MktException(errorCode);
    }

    public static MktException build(BaseResponseCode errorCode, String message) {
        return new MktException(errorCode, message);
    }
}
