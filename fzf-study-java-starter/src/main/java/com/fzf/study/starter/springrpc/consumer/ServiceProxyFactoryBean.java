package com.fzf.study.starter.springrpc.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/6 5:34 下午
 * @description:
 * @version: v1.0
 */
public class ServiceProxyFactoryBean extends HttpInvokerProxyFactoryBean {


    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private AmqpTemplate amqpTemplate;



    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        logger.info("调用 ServiceProxyFactoryBean");
    }

}
