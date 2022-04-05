/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:22
 * @description: 邀请人信息
 * @version: v1.0
 */
@Builder
@Data
public class Inviter {

    /**
     * 邀请人客户号
     */
    private Long inviterCustomerNo;

    /**
     * 邀请人姓名
     */
    private String inviterName;

    /**
     * 邀请人证件号
     */
    private String inviterIdNo;

    /**
     * 邀请行员编号
     */
    private String bankEmployeeNo;

    /**
     * 邀请人网点号
     */
    private String inviterBankBranchNo;

    /**
     * 邀请优质企业编号
     */
    private String highualityCompanyCode;

    /**
     * 邀请优质企业名称
     */
    private String highualityCompanyName;

    /**
     * 邀请优质企业简称
     */
    private String highualityCompanyShortName;

}
