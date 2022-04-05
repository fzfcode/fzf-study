package com.fzf.study.domain.common;

import com.fzf.study.dictionary.enums.ActivityParticipateStatusEnum;
import lombok.Builder;
import lombok.Getter;

/**
 * 活动参与状态
 * @author sunke04
 */
@Builder
@Getter
public class ActivityParticipateStatement {

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
     */
    private ActivityParticipateStatusEnum status;
}
