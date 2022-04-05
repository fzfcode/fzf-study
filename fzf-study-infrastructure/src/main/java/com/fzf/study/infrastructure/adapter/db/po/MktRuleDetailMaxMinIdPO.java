package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2021-03-02 15:19:45
 * @description: 活动拓展记录最大ID、最小ID对象
 */
@Data
@Builder
public class MktRuleDetailMaxMinIdPO {

    /**
     * 最大ID
     */
    private Long maxId;

    /**
     * 最小ID
     */
    private Long minId;

}
