package com.fzf.study.rpc.adapter.socket.factory;

import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.service.NFSService;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.SpringContextUtil;

import java.util.Map;

public class NFSServiceFactory {

    private Map<String,Class> handlerMap;

    public NFSServiceFactory(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public NFSService getInstance(String type){

        Class clazz = handlerMap.get(type);
        if (clazz ==null){
            throw  new IllegalArgumentException("not found handler for nfs service :" +type);
        }
        return (NFSService) SpringContextUtil.getBean(clazz,type);
    }
}
