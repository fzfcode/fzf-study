package com.fzf.study.domain.common;

/**
 * @author: zhujianxun
 * @date: 2020/9/14 9:41 下午
 * @description: 外部活动实体Repository
 */
public interface ExternalActivityRepository {
    /**
     * 根据类型查询活动
     * @param type 活动类型
     * @return ExternalActivity
     */
    ExternalActivity queryByType(String type);
}
