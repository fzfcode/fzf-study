package com.fzf.study.rpc.adapter.socket.processor;


import com.google.common.collect.Maps;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.factory.NFSServiceFactory;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String NFS_SERVICE_PACKAGE = "com.sankuai.meituan.mkt.activity.rpc.adapter";


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        HashMap<String, Class> handleMap = Maps.newHashMap();
        Reflections reflection = new Reflections(NFS_SERVICE_PACKAGE);
        Set<Class<?>> classes = reflection.getTypesAnnotatedWith(NFSServiceId.class);
        for (Class<?> clazz : classes) {

            String type = clazz.getAnnotation(NFSServiceId.class).type();
            handleMap.put(type, clazz);
        }
        NFSServiceFactory context = new NFSServiceFactory(handleMap);
        beanFactory.registerSingleton(NFSServiceFactory.class.getName(), context);
    }
}
