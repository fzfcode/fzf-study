/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.po.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: HouGang
 * @date: 2020/9/12 16:06
 * @description:
 * @version: v1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoPO {

    /**
     * 客户信息主键ID
     */
    private Long id;

    /**
     * 客户号
     */
    private Integer custno;

    /**
     * 行内客户号
     */
    private String bkCustNo;

    /**
     * 机构号
     */
    private String orgno;

    /**
     * 称谓
     */
    private String title;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 本行员工号
     */
    private String bankmemberNo;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 是否永久居住
     */
    private String prOfCountry;

    /**
     * 永久居住国家代码
     */
    private String residencyCountryCd;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 教育状况
     */
    private String qualification;

    /**
     * 风险情况
     */
    private String socialStatus;

    /**
     * 发证机关所在地址
     */
    private String idIssuerAddress;

    /**
     * 家庭电话
     */
    private String homePhone;

    /**
     * 房屋持有类型
     */
    private String houseOwnership;

    /**
     * 住宅类型
     */
    private String houseType;

    /**
     * 现住址居住起始年月
     */
    private String homeStandFrom;

    /**
     * 个人资产类型
     */
    private String liquidAsset;

    /**
     * 移动电话
     */
    private String mobileNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 就业状态
     */
    private String empStatus;

    /**
     * 抚养人数
     */
    private Integer nbrOfDependents;

    /**
     * 语言代码
     */
    private String languageInd;

    /**
     * 创建日期
     */
    private String setupDate;

    /**
     * 社保缴存金额
     */
    private BigDecimal socialInsAmt;

    /**
     * 驾驶证号码
     */
    private String driveLicenseId;

    /**
     * 驾驶证登记日期
     */
    private String driveLicRegDate;

    /**
     * 预留问题
     */
    private String obligateQuestion;

    /**
     * 预留答案
     */
    private String obligateAnswer;

    /**
     * 工作稳定性
     */
    private String empStability;

    /**
     * 公司名称
     */
    private String corpName;

    /**
     * 凸印姓名
     */
    private String embName;

    /**
     * 证件类型
     */
    private String idType;

    /**
     * 证件号
     */
    private String certno;

    /**
     * 到期日
     */
    private Date expiryDate;

    /**
     * 国家代码
     */
    private String countryCd;

    /**
     * 客户类型
     */
    private String custType;

    /**
     * 学位信息
     */
    private String degree;

    /**
     * 任职部门
     */
    private String department;

    /**
     * 证件到期日
     */
    private String idExpireDate;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
