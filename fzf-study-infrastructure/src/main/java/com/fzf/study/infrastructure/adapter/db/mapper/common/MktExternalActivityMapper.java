package com.fzf.study.infrastructure.adapter.db.mapper.common;

import com.fzf.study.infrastructure.adapter.db.po.common.ExternalActivityPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 2:05 下午
 * @description: 外部活动Mapper
 */
public interface MktExternalActivityMapper {
    /**
     * 查询外部活动
     * @param type 活动类型
     * @return ExternalActivityPO
     */
    ExternalActivityPO queryByType(@Param("activityType") String type);
}
