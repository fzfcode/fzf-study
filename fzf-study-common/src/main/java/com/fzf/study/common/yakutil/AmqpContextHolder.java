package com.fzf.study.common.yakutil;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/5 4:16 下午
 * @description: 在线程上下文存放交易入口生成的内部流水号
 * rpc调用时向被调用方传递
 * @version: v1.0
 */
public class AmqpContextHolder {
    public static ThreadLocal<String> aicSrcTradeId = new ThreadLocal<String>(); //交易入口生成的内部流水号
    public static ThreadLocal<String> org = new ThreadLocal<String>();
    public static ThreadLocal<String> username = new ThreadLocal<String>();

    public static ThreadLocal<String> getAicSrcTradeId() {
        return aicSrcTradeId;
    }

    public static void setAicSrcTradeId(ThreadLocal<String> aicSrcTradeId) {
        AmqpContextHolder.aicSrcTradeId = aicSrcTradeId;
    }

    public static ThreadLocal<String> getOrg() {
        return org;
    }

    public static void setOrg(ThreadLocal<String> org) {
        AmqpContextHolder.org = org;
    }

    public static ThreadLocal<String> getUsername() {
        return username;
    }

    public static void setUsername(ThreadLocal<String> username) {
        AmqpContextHolder.username = username;
    }
}
