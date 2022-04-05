package com.fzf.study.infrastructure.adapter.db.po;

import java.util.Date;
import lombok.Builder;
import lombok.Data;


/**
 * @author: HouGang
 * @date: 2021-03-04 14:35:28
 * @description: 活动报名下行短信信息PO
 * @version: v1.0
 */

@Builder
@Data
public class ActivitySignUpSmsDetailPO {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 短信活动识别码
     */
    private String activityCode;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 报名申请号类型
     */
    private Integer memberType;

    /**
     * 报名申请号
     */
    private String memberNo;

    /**
     * 发送次数
     */
    private Integer sendTimes;

    /**
     * 状态
     */
    private Integer sendStatus;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
