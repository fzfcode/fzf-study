/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.support.bank.invitation.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author: HouGang
 * @date: 2020/9/11 15:22
 * @description: 被邀请人申请信息
 * @version: v1.0
 */
@Builder
@Data
public class Invitee {

    /**
     * 申请人姓名
     */
    private String inviteeName;

    /**
     * 申请人手机号
     */
    private String inviteePhone;

    /**
     * 申请人身份证号
     */
    private String inviteeIdNo;

}
