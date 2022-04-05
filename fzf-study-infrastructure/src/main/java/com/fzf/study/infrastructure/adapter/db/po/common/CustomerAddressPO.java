package com.fzf.study.infrastructure.adapter.db.po.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressPO {
    private Long id;

    private String orgno;

    private Integer addrId;

    private Integer custno;

    private String addrType;

    private String countryCd;

    private String state;

    private String city;

    private String district;

    private String zip;

    private String phone;

    private String address;

    private Date creatTime;

    private Date updateTime;
}