package com.fzf.study.domain.common;

import com.fzf.study.dictionary.enums.ActivityStatusEnum;
import com.fzf.study.dictionary.enums.ActivityTypeEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/8 4:01 下午
 * @description: 活动基本信息
 */
@SuperBuilder(toBuilder = true)
@Getter
@EqualsAndHashCode
public class BaseActivity {

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
     */
    private ActivityTypeEnum activityType;

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
     * 活动状态
     */
    private ActivityStatusEnum status;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;
}
