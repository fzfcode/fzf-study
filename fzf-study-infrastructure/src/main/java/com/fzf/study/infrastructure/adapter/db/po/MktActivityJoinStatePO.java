package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 活动参与状态
 * @author sunke04
 */
@Data
@Builder
public class MktActivityJoinStatePO {

    /**
     * id
     */
    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 参与活动渠道
     */
    private String participateChannel;

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 优惠内容
     */
    private String preferentialContent;

    /**
     * 活动参与状态
     * 0:已冻结,1:已确认,2:已失效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
