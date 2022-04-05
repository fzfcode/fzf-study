/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.repository;


import com.fzf.study.domain.common.sms.OperateLog;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 11:50 上午
 * @description:
 */
public interface OperateLogRespository {

    public void recordOperateLog(OperateLog operateLog);
}
