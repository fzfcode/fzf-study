package com.fzf.study.starter.spring.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.support.RemoteInvocationBasedExporter;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/6 9:04 上午
 * @description:
 * @vrsion: v1.0
 */
public class AmqpInvokerServiceExporter extends RemoteInvocationBasedExporter implements MessageListener, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private AmqpTemplate amqpTemplate;


    @Override
    public void onMessage(Message message) {
        logger.info("执行   AmqpInvokerServiceExporter");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }
}
