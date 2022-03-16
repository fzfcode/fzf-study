package com.fzf.study.infrastructure.db.mapper.common;

import com.fzf.study.infrastructure.db.po.common.CustomerAddressPO;
import org.apache.ibatis.annotations.Param;

public interface CustomerAddressMapper {

    /**
     * 查询客户地址数量
     *
     * @param customerNo 客户号
     * @param addrType   地址类型
     * @return 数量
     */
    long countByCustomerNoAndType(@Param("customerNo") Integer customerNo, @Param("addrType") String addrType);

    /**
     * 新增客户地址信息记录
     *
     * @param customerAddressPO 地址信息
     */
    long addCustomerAddress(CustomerAddressPO customerAddressPO);

    /**
     * 更新客户地址信息记录
     *
     * @param customerAddressPO 地址信息
     */
    long updateCustomerAddress(@Param("record") CustomerAddressPO customerAddressPO);


}