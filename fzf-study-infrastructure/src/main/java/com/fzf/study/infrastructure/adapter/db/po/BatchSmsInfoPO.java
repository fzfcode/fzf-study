/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Data;

/**
 * @author: zhujianxun
 * @date: 2020/9/27 5:55 下午
 * @description: 批量短信信息PO
 */
@Data
public class BatchSmsInfoPO {
    private String keyNo;

    private String org;

    private String serialNumber;

    private String mobileNo;

    private String msgInfo;

    private String sendBeginTime;

    private String sendEndTime;

    private String remark;

    private String labelType;

    public BatchSmsInfoPO() {
    }
}
