package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author fanglietao
 * @version 1.0
 * @date 2021/1/16 8:17 下午
 * @description
 */
@Builder
@Data
public class AcctInfoPO {
    private Integer acctNo;

    private String acctType;

    private Integer custId;

    private String blockCode;

    private Long creditLimit;

    private BigDecimal ctdRetailAmt;

    private Integer ctdRetailCnt;

    private BigDecimal currBal;

    private String graceDaysFullInd;

    private BigDecimal mtdRetailAmt;

    private Integer mtdRetailCnt;

    private BigDecimal principalBal;

    private String productCd;

    private BigDecimal ytdRetailAmt;

    private Integer ytdRetailCnt;

    private String defaultLogicalCardNo;

    private String lastStmtDate;

    private String pmtDueDate;

    private String currCd;

    private String mobileNo;

    private BigDecimal qualGraceBal;

    private BigDecimal totDueAmt;

    private String name;

}
