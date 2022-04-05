/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.domain.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zhujianxun
 * @date: 2020/9/29 11:09 上午
 * @description: 卡片基础信息
 */
@Getter
@Setter
@EqualsAndHashCode
public class CardBaseInfo {
    private Long id;

    private String logicalCardno;

    private String orgno;

    private Integer acctno;

    private Integer custno;

    private String prodno;

    private String appno;

    private String barcode;

    private String bscSuppInd;

    private String bscLogiccardNo;

    private String owningBranch;

    private String appPromotionCd;

    private String recomId;

    private String recomName;

    private String recomCardNo;

    private String setupDate;

    private String blockCode;

    private String activateInd;

    private String activateDate;

    private String cancelDate;

    private String expireDate;

    private String latestCardNo;

    private String oldCardNo;

    private String appSource;

    private String representName;

    private String posPinVerifyInd;

    private String relationshipToBsc;

    private String cardExpireDate;

    private BigDecimal cardFeeRate;

    private String renewInd;

    private String renewRejectCd;

    private String firstCardFeeDate;

    private String lastRenewalDate;

    private String firstUsageFlag;

    private String nextCardFeeDate;

    private String waiveCardfeeInd;

    private String cardFetchMethod;

    private String cardMailerInd;

    private String firstUsageDate;

    private String fetchBranch;

    private String cancelReason;

    private String electronicInd;

    private String activateBranch;

    private String accepterName;

    private String accepterEmpId;

    private String recomSourceCd;

    private Date creatTime;

    private Date updateTime;
}
