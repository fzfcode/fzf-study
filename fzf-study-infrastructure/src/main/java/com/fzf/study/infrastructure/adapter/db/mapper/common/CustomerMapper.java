/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.mapper.common;

import com.fzf.study.infrastructure.adapter.db.po.common.CustomerInfoPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: HouGang
 * @date: 2020/9/12 16:05
 * @description: 客户信息Mapper
 * @version: v1.0
 */
public interface CustomerMapper {

    /**
     * 根据客户号获取客户信息
     *
     * @param customerNo
     * @return CustomerInfoPO
     */
    CustomerInfoPO queryCustomerByCustomerNo(@Param("customerNo") long customerNo);


    /**
     * 根据客户号获取客户手机号
     *
     * @param customerNo
     * @return
     */
    String queryCustomerMobileNoByCustomerNo(@Param("customerNo") long customerNo);

    /**
     * 保存客户
     *
     * @param customerInfo
     * @return
     */
    int insertSelective(CustomerInfoPO customerInfo);

    /**
     * 查询客户手机号
     *
     * @param idType 证件类型
     * @param idNo   证件号
     * @return 手机号
     */
    String queryMobileNoByIdNo(@Param("idType") String idType, @Param("idNo") String idNo);


    /**
     * 查询客户信息数量
     *
     * @param customerNo 客户号
     * @return 数量
     */
    long countByCustomerNo(@Param("customerNo") Integer customerNo);

    /**
     * 更新客户地址信息记录
     *
     * @param customerInfoPO 客户信息
     */
    long updateCustomerInfo(@Param("record") CustomerInfoPO customerInfoPO);

}
