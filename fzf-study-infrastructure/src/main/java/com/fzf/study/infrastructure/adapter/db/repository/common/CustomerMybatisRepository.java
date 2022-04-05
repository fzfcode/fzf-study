/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.domain.common.model.Customer;
import com.fzf.study.domain.common.repository.CustomerRepository;
import com.fzf.study.infrastructure.adapter.db.converter.common.CustomerConverter;
import com.fzf.study.infrastructure.adapter.db.mapper.common.CustomerMapper;
import com.fzf.study.infrastructure.adapter.db.po.common.CustomerInfoPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author: HouGang
 * @date: 2020/9/12 16:03
 * @description: 客户信息Repository
 * @version: v1.0
 */
@Repository("customerRepository")
public class CustomerMybatisRepository implements CustomerRepository {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public Customer queryCustomerByCustomerNo(long customerNo) {
        return CustomerConverter
                .convert2Customer(customerMapper.queryCustomerByCustomerNo(customerNo));
    }

    @Override
    public String queryCustomerMobileNoByCustomerNo(long customerNo) {
        return customerMapper.queryCustomerMobileNoByCustomerNo(customerNo);
    }

    @Override
    public int insertSelective(Customer customer) {
        CustomerInfoPO customerInfoPO = CustomerConverter.convert2CustomerInfoPO(customer);
        return customerMapper.insertSelective(customerInfoPO);
    }
}
