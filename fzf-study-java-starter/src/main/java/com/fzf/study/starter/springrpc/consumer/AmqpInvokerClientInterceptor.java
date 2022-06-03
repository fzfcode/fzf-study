package com.fzf.study.starter.springrpc.consumer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/6 8:20 下午
 * @description:
 * @version: v1.0
 */
public class AmqpInvokerClientInterceptor implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
