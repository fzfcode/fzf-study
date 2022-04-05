package com.fzf.study.domain.common.client;

/**
 * @author: zhujianxun
 * @date: 2020/9/22 5:03 下午
 * @description: 下行短信适配服务
 */
public interface DownSmsAdaptService {
    /**
     * 发送下行短信
     * @param smsInfo 短信实体
     */
    void sendMessage(SmsInfo smsInfo);

    /**
     * 发送下行短信-营销短信通道
     * @param smsInfo 短信实体
     */
    void sendMarketingMessage(SmsInfo smsInfo);

}
