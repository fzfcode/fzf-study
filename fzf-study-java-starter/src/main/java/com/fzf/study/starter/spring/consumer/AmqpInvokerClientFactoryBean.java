package com.fzf.study.starter.spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.Proxy;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/6 8:19 下午
 * @description:
 * @version: v1.0
 */
public class AmqpInvokerClientFactoryBean<T> extends AmqpInvokerClientInterceptor implements FactoryBean<T>, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Class<?> serviceInterface;

    @Override
    public T getObject() throws Exception {
        return (T)Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{serviceInterface},this );
    }


    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public Class<?> getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(Class<?> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

}
