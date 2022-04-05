package com.fzf.study.domain.common;


import com.fzf.study.domain.common.client.UmsSmsLog;

/**
 * @author: zhujianxun
 * @date: 2020/9/28 4:41 下午
 * @description: 上行短信日志Repository
 */
public interface UmsSmsLogRepository {
    /**
     * 新增上行短信记录
     * @param smsLog 短信记录
     * @return int
     */
    int addSmsLogRecord(UmsSmsLog smsLog);
}
