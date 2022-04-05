package com.fzf.study.infrastructure.adapter.db.po.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardMediaInfoPO {
    private Long id;

    private String orgno;

    private String cardno;

    private String oldCardno;

    private String firstCardno;

    private String productCd;

    private String photoInd;

    private String embName;

    private String embCompany;

    private String setupDate;

    private String activateDate;

    private String activeInd;

    private String lastActiveInd;

    private String expiryDate;

    private String lastExpiryDate;

    private String nextChangeDate;

    private String cancelDate;

    private String designCd;

    private String blockCd;

    private String appNo;

    private String bscSuppInd;

    private String bscSuppIndDesc;

    private String logiCardno;

    private String lastDesignCd;

    private String owningBranch;

    private String lastActivateDate;

    private String electronicInd;

    private Date creatTime;

    private Date updateTime;

}