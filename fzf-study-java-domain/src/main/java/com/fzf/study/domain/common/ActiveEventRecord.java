package com.fzf.study.domain.common;

import com.fzf.study.dictionary.enums.SmsSendStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/9 9:31 下午
 * @description: 活动更新记录
 */
@Builder
@Getter
@Setter
public class ActiveEventRecord {
    /**
     * id
     */
    private Long id;
    /**
     * 原始信息
     */
    private String originalInfo;
    /**
     * 关键字类型
     */
    private String keyType;
    /**
     * 属性值
     */
    private String keyNo;
    /**
     * 手机号
     */
    private String mobileNo;
    /**
     * 标签类型
     */
    private String labelType;
    /**
     * 发送类型
     */
    private String sendType;
    /**
     * 发送状态
     */
    private String sendStatus;
    /**
     * 回复码
     */
    private String replayFlag;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public void confirm(){
        this.setSendStatus(SmsSendStatusEnum.SEND_SUCCESS.getSendStatus());
    }

    public void fail(){
        this.setSendStatus(SmsSendStatusEnum.SEND_FAIL.getSendStatus());
    }
}
