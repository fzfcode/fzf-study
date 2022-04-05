/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.domain.common.AccountInfo;
import com.fzf.study.domain.common.repository.AccountRepository;
import com.fzf.study.infrastructure.adapter.db.converter.activity.AcctBaseInfoConverter;
import com.fzf.study.infrastructure.adapter.db.mapper.AcctBaseInfoMapper;
import com.fzf.study.infrastructure.adapter.db.mapper.common.AccountMapper;
import com.fzf.study.infrastructure.adapter.db.po.AcctInfoPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: HouGang
 * @date: 2020-09-14 18:48:59
 * @description: 账户信息Resository
 * @version: v1.0
 */
@Repository("accountRepository")
public class AccountMybatisRepository implements AccountRepository {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AcctBaseInfoMapper acctBaseInfoMapper;

    @Override
    public List<String> queryAccountBlockCodeByIdNo(String idNo) {
        return accountMapper.queryAccountBlockCodeByIdNo(idNo);
    }

    @Override
    public AccountInfo queryAnyAccountByMobileNo(String mobileNo) {
        AcctInfoPO acctInfoPO = acctBaseInfoMapper.queryOneByMobileNo(mobileNo);
        if (null == acctInfoPO) {
            return null;
        }
        return AcctBaseInfoConverter.convert2CardBaseInfo(acctInfoPO);
    }

    @Override
    public AccountInfo queryAccountBy(Integer acctNo) {
        AcctInfoPO acctInfoPO = acctBaseInfoMapper.queryByAcctNo(acctNo);
        if (null == acctInfoPO) {
            return null;
        }
        return AcctBaseInfoConverter.convert2CardBaseInfo(acctInfoPO);
    }


    @Override
    public boolean hasValidAcctInfo(String acctNo, String idNo) {

        return accountMapper.queryIdNoByUserInfo(acctNo, idNo) > 0;
    }

}
