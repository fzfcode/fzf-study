package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/11 3:42 下午
 * @description: 活动扩展信息PO
 */
@Builder
@Data
public class ActivityExtPO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 扩展类型
     */
    private String extType;

    /**
     * 扩展信息详情
     */
    private String extDetail;

    /**
     * 扩展信息状态
     * 数据库表遗留字段，应用中禁止使用
     */
    @Deprecated
    private Integer status;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
