package com.fzf.study.domain.common.repository;


import com.fzf.study.dictionary.enums.DictTypeEnum;
import com.fzf.study.domain.common.MktDict;

import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/12/15 7:20 下午
 * @description: 路由配置Repository
 */
public interface RouteConfigRepository {

    /**
     * 查询路由配置值
     * @param routeKey 路由key
     * @return 路由配置值
     */
    String queryRouteConfigValue(String routeKey);


    /**
     * 查询字典配置列表
     * @param dictType 路由key
     * @return 字典配置列表
     */
    List<MktDict> queryRouteConfigValues(DictTypeEnum dictType);
}
