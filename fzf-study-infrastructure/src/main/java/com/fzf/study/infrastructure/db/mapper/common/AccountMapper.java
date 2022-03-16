/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.db.mapper.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: HouGang
 * @date: 2020/9/14 17:50
 * @description: 账户信息Mapper
 * @version: v1.0
 */
public interface AccountMapper {

    /**
     * 根据证件号获取账户锁定码
     * @param idNo
     * @return 锁定码
     */
    List<String> queryAccountBlockCodeByIdNo(@Param("idNo") String idNo);

    /**
     * 根据账户号查询count证件信息
     * @param acctNo  账户号
     * @param idNo 证件号
     */
    Integer queryIdNoByUserInfo(@Param("acctNo") String acctNo, @Param("idNo") String idNo);

}
