package com.fzf.study.infrastructure.adapter.db.po;

import com.fzf.study.dictionary.enums.ActivityStatusEnum;
import com.fzf.study.dictionary.enums.ActivityTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/3 9:46 下午
 * @description: 活动PO
 */
@Data
@Builder
public class ActivityPO {

    /**
     * 活动id
     */
    private Long id;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动类型
     * {@link ActivityTypeEnum}
     */
    private Integer type;

    /**
     * 活动状态
     * {@link ActivityStatusEnum}
     */
    private Integer status;

    /**
     * 活动描述
     */
    private String description;

    /**
     * 有效开始时间
     */
    private Date validStartTime;

    /**
     * 有效结束时间
     */
    private Date validEndTime;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
