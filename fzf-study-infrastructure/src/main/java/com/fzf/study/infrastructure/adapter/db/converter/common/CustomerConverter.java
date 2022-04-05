/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.converter.common;


import com.fzf.study.domain.common.model.Customer;
import com.fzf.study.infrastructure.adapter.db.po.common.CustomerInfoPO;

import java.util.Objects;

/**
 * @author: HouGang
 * @date: 2020/9/12 16:18
 * @description: 客户信息转换器
 * @version: v1.0
 */
public class CustomerConverter {

    public static Customer convert2Customer(CustomerInfoPO customerInfoPO) {
        if (Objects.isNull(customerInfoPO)) {
            return null;
        }

        return Customer.builder()
                .customerName(customerInfoPO.getName())
                .customerNo(customerInfoPO.getCustno())
                .idNo(customerInfoPO.getCertno())
                .idType(customerInfoPO.getIdType())
                .mobileNo(customerInfoPO.getMobileNo())
                .build();
    }

    public static CustomerInfoPO convert2CustomerInfoPO(Customer customer) {
        if (Objects.isNull(customer)) {
            return null;
        }

        return CustomerInfoPO.builder()
                .name(customer.getCustomerName())
                .custno(customer.getCustomerNo())
                .certno(customer.getIdNo())
                .idType(customer.getIdType())
                .mobileNo(customer.getMobileNo())
                .build();
    }
}
