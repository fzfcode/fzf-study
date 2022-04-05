package com.fzf.study.infrastructure.adapter.db.mapper;


import com.fzf.study.infrastructure.adapter.db.po.MktDictPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MktDictMapper {
    /**
     * 查询字典配置
     * @param dictType 类型
     * @param dictKey Key
     * @return List<MktDictPO>
     */
    MktDictPO queryMktDictByType(@Param("dictType") String dictType, @Param("dictKey") String dictKey);

    /**
     * 查询字典配置
     * @param dictType 类型
     * @param dictKey Key
     * @return MktDictPO
     */
    List<MktDictPO> queryListByTypeAndKey(@Param("dictType") String dictType, @Param("dictKey") String dictKey);


    /**
     * 查询字典配置列表
     * @param dictType 类型
     * @return List<MktDictPO>
     */
    List<MktDictPO> queryMktDictListByType(@Param("dictType") String dictType);

}