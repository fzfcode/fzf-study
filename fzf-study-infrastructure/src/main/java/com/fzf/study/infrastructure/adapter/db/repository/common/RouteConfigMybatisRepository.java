package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.dictionary.enums.DictTypeEnum;
import com.fzf.study.domain.common.MktDict;
import com.fzf.study.domain.common.repository.RouteConfigRepository;
import com.fzf.study.infrastructure.adapter.db.mapper.MktDictMapper;
import com.fzf.study.infrastructure.adapter.db.po.MktDictPO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: SunKe
 * @date: 2020/12/15 7:24 下午
 * @description: 路由配置Repository
 */
@Repository("routeConfigRepository")
public class RouteConfigMybatisRepository implements RouteConfigRepository {

    @Resource
    private MktDictMapper mktDictMapper;

    @Override
    public String queryRouteConfigValue(String routeKey) {
        MktDictPO mktDictPo = mktDictMapper.queryMktDictByType(DictTypeEnum.ROUTE_CONFIG.getValue(), routeKey);
        if (Objects.isNull(mktDictPo)) {
            return null;
        }
        return mktDictPo.getDictValue();
    }

    @Override
    public List<MktDict> queryRouteConfigValues(DictTypeEnum dictType) {
        List<MktDictPO> mktDictPo = mktDictMapper.queryMktDictListByType(dictType.getValue());
        if (CollectionUtils.isEmpty(mktDictPo)) {
            return new ArrayList<>();
        }

        return mktDictPo.stream().map(RouteConfigMybatisRepository::convert2MktDict).collect(Collectors.toList());
    }


    private static MktDict convert2MktDict(MktDictPO mktDictPO) {
        return MktDict.builder()
                .id(mktDictPO.getId())
                .dictType(mktDictPO.getDictType())
                .dictKey(mktDictPO.getDictKey())
                .dictValue(mktDictPO.getDictValue())
                .dictDesc(mktDictPO.getDictDesc())
                .addTime(mktDictPO.getAddTime())
                .updateTime(mktDictPO.getUpdateTime())
                .build();
    }


}
