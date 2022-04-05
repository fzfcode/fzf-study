package com.fzf.study.domain.common;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.MktException;
import com.fzf.study.dictionary.exception.MktExceptionBuilder;

/**
 * @author: SunKe
 * @date: 2020/9/10 4:58 下午
 * @description: 断言工具类
 */
public class MktActivityAssertUtils {
    /**
     * 当前条件是否为true, 不为true,则抛出异常e
     *
     * @param condition 判断的条件
     * @param e         condition为false,需要抛出的异常
     */
    public static void assertTrue(boolean condition, MktException e) {
        if (!condition) {
            throw e;
        }
    }

    /**
     * 当前条件是否为true, 不为true,则抛出异常
     *
     * @param condition 判断的条件
     * @param errorCode condition为false,需要抛出的异常的错误码
     */
    public static void assertTrue(boolean condition, BaseResponseCode errorCode) {
        if (!condition) {
            throw MktExceptionBuilder.build(errorCode);
        }
    }

    /**
     * 当前条件是否为true, 不为true,则抛出异常
     *
     * @param condition 判断的条件
     * @param errorCode condition为false,需要抛出的异常的错误码
     * @param msg       错误信息
     */
    public static void assertTrue(boolean condition, BaseResponseCode errorCode, String msg) {
        if (!condition) {
            throw MktExceptionBuilder.build(errorCode, msg);
        }
    }

    /**
     * 当前对象不可为空,否则抛出异常e
     *
     * @param target 需要判断的对象
     * @param e      为空时,抛出的异常
     */
    public static void assertNotNull(Object target, MktException e) {
        if (target == null) {
            throw e;
        }
    }

    /**
     * 当前对象不可为空,否则抛出异常
     *
     * @param target    需要判断的对象
     * @param errorCode 为空时,抛出的异常的错误码
     */
    public static void assertNotNull(Object target, BaseResponseCode errorCode) {
        if (target == null) {
            throw MktExceptionBuilder.build(errorCode);
        }
    }

    /**
     * 前对象不可为空,否则抛出异常
     *
     * @param target    需要判断的对象
     * @param errorCode 为空时,抛出的异常的错误码
     * @param msg       错误信息
     */
    public static void assertNotNull(Object target, BaseResponseCode errorCode, String msg) {
        if (target == null) {
            throw MktExceptionBuilder.build(errorCode, msg);
        }
    }
}
