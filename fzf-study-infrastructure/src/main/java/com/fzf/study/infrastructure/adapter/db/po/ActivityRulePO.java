package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/12 5:31 下午
 * @description: 活动规则PO
 */
@Builder
@Data
public class ActivityRulePO {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 事件类型
     */
    private Integer eventType;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则值
     */
    private String ruleValue;

    /**
     * 规则值格式类型
     */
    private String valueFormatType;

    /**
     * 规则描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;


}
