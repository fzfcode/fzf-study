/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common.repository;


import com.fzf.study.domain.common.model.Customer;

/**
 * @author: HouGang
 * @date: 2020/9/12 15:06
 * @description: 客户信息Repository
 * @version: v1.0
 */
public interface CustomerRepository {

    /**
     * 根据客户号获取客户信息
     * @param customerNo
     * @return Customer
     */
    Customer queryCustomerByCustomerNo(long customerNo);

    /**
     * 根据客户号获取客户手机号
     * @param customerNo
     * @return
     */
    String queryCustomerMobileNoByCustomerNo(long customerNo);

    /**
     * 保存客户
     * @param customer
     * @return
     */
    int insertSelective(Customer customer);

}
