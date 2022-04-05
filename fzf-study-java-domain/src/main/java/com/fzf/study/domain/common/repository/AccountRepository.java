/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.repository;


import com.fzf.study.domain.common.AccountInfo;

import java.util.List;

/**
 * @author: HouGang
 * @date: 2020-09-12 20:21:03
 * @description: 账户信息Repository
 * @version: v1.0
 */
public interface AccountRepository {

    /**
     * 根据证件号获取账户锁定码
     * @param idNo
     * @return 锁定码
     */
    List<String> queryAccountBlockCodeByIdNo(String idNo);

    AccountInfo queryAnyAccountByMobileNo(String mobileNo);

    AccountInfo queryAccountBy(Integer acctNo);

    /**
     * 账户信息是否有效
     * @return
     */
    boolean hasValidAcctInfo(String acctNo, String idNo);
}
