package com.fzf.study.domain.common.repository;


import com.fzf.study.domain.common.model.CardBaseInfo;

import java.util.Date;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/15
 * @Version:
 * @Description:
 */


public interface CardBaseInfoRepository {
    String getLogicalCardNoByAcctNoAndLatestCardNo(Integer acctNo, String latestCardNo);
    CardBaseInfo selectByLatestCardNo(String latestCardNo);

    Date queryCardActivateDate(String cardNo);
}
