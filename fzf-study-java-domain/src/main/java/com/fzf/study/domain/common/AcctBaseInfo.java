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
 * @date: 2020/9/29 11:38 上午
 * @description: 账户基础信息
 */
@Getter
@Setter
@EqualsAndHashCode
public class AcctBaseInfo {
    private Long id;

    private String org;

    private Integer acctNo;

    private String acctType;

    private Integer custId;

    private Integer custLimitId;

    private String productCd;

    private String defaultLogicalCardNo;

    private String currCd;

    private Long creditLimit;

    private Long tempLimit;

    private String tempLimitBeginDate;

    private String tempLimitEndDate;

    private BigDecimal cashLimitRt;

    private BigDecimal ovrlmtRate;

    private BigDecimal loanLimitRt;

    private BigDecimal currBal;

    private BigDecimal cashBal;

    private BigDecimal principalBal;

    private BigDecimal loanBal;

    private BigDecimal disputeAmt;

    private BigDecimal beginBal;

    private BigDecimal pmtDueDayBal;

    private BigDecimal qualGraceBal;

    private String graceDaysFullInd;

    private Long pointBeginBal;

    private Long ctdEarnedPoints;

    private Long ctdDisbPoints;

    private Long ctdAdjPoints;

    private Long pointBal;

    private String setupDate;

    private String dormentDate;

    private String reinstateDate;

    private String ovrlmtDate;

    private Integer ovrlmtNbrOfCyc;

    private String name;

    private String gender;

    private String owningBranch;

    private String mobileNo;

    private String corpName;

    private String billingCycle;

    private String stmtFlag;

    private String stmtMailAddrInd;

    private String stmtMediaType;

    private String stmtCountryCd;

    private String stmtState;

    private String stmtCity;

    private String stmtDistrict;

    private String stmtAddress;

    private String stmtZip;

    private String email;

    private String blockCode;

    private String ageCd;

    private String glAgeCd;

    private BigDecimal unmatchDb;

    private BigDecimal unmatchCash;

    private BigDecimal unmatchCr;

    private String ddInd;

    private String ddBankName;

    private String ddBankBranch;

    private String ddBankAcctNo;

    private String ddBankAcctName;

    private BigDecimal lastDdAmt;

    private String lastDdDate;

    private String dualBillingFlag;

    private BigDecimal lastPmtAmt;

    private String lastPmtDate;

    private String lastStmtDate;

    private String lastPmtDueDate;

    private String lastAgingDate;

    private String collectDate;

    private String collectOutDate;

    private String nextStmtDate;

    private String pmtDueDate;

    private String ddDate;

    private String graceDate;

    private String dlblDate;

    private String closedDate;

    private String firstStmtDate;

    private String cancelDate;

    private String chargeOffDate;

    private String firstPurchaseDate;

    private BigDecimal firstPurchaseAmt;

    private BigDecimal totDueAmt;

    private BigDecimal currDueAmt;

    private BigDecimal pastDueAmt1;

    private BigDecimal pastDueAmt2;

    private BigDecimal pastDueAmt3;

    private BigDecimal pastDueAmt4;

    private BigDecimal pastDueAmt5;

    private BigDecimal pastDueAmt6;

    private BigDecimal pastDueAmt7;

    private BigDecimal pastDueAmt8;

    private BigDecimal ctdCashAmt;

    private Integer ctdCashCnt;

    private BigDecimal ctdRetailAmt;

    private Integer ctdRetailCnt;

    private BigDecimal ctdPaymentAmt;

    private Integer ctdPaymentCnt;

    private BigDecimal ctdDbAdjAmt;

    private Integer ctdDbAdjCnt;

    private BigDecimal ctdCrAdjAmt;

    private Integer ctdCrAdjCnt;

    private BigDecimal ctdFeeAmt;

    private Integer ctdFeeCnt;

    private BigDecimal ctdInterestAmt;

    private Integer ctdInterestCnt;

    private BigDecimal ctdRefundAmt;

    private Integer ctdRefundCnt;

    private BigDecimal ctdHiOvrlmtAmt;

    private BigDecimal mtdRetailAmt;

    private Integer mtdRetailCnt;

    private BigDecimal mtdCashAmt;

    private Integer mtdCashCnt;

    private BigDecimal mtdRefundAmt;

    private Integer mtdRefundCnt;

    private BigDecimal ytdRetailAmt;

    private Integer ytdRetailCnt;

    private BigDecimal ytdCashAmt;

    private Integer ytdCashCnt;

    private BigDecimal ytdRefundAmt;

    private Integer ytdRefundCnt;

    private BigDecimal ytdOvrlmtFeeAmt;

    private Integer ytdOvrlmtFeeCnt;

    private BigDecimal ytdLpcAmt;

    private Integer ytdLpcCnt;

    private BigDecimal ltdRetailAmt;

    private Integer ltdRetailCnt;

    private BigDecimal ltdCashAmt;

    private Integer ltdCashCnt;

    private BigDecimal ltdRefundAmt;

    private Integer ltdRefundCnt;

    private BigDecimal ltdHighestPrincipal;

    private BigDecimal ltdHighestCrBal;

    private BigDecimal ltdHighestBal;

    private Integer collectTimes;

    private String collectColr;

    private String collectReason;

    private String ageHist;

    private String paymentHist;

    private String waiveOvlfeeInd;

    private String waiveCardfeeInd;

    private String waiveLatefeeInd;

    private String waiveSvcfeeInd;

    private BigDecimal userAmt4;

    private BigDecimal userAmt5;

    private BigDecimal userAmt6;

    private Integer jpaVersion;

    private BigDecimal mtdPaymentAmt;

    private Integer mtdPaymentCnt;

    private BigDecimal ytdPaymentAmt;

    private Integer ytdPaymentCnt;

    private BigDecimal ltdPaymentAmt;

    private Integer ltdPaymentCnt;

    private String smsInd;

    private BigDecimal userSmsAmt;

    private Integer ytdCycleChagCnt;

    private String lastPostDate;

    private BigDecimal largeLoanBal;

    private BigDecimal beginLoanBal;

    private BigDecimal beginLargeLoanBal;

    private BigDecimal highestBalOutLargeLoan;

    private BigDecimal highestBalOutLoan;

    private String isUseCustOtb;

    private BigDecimal txnMicroCreditIntRate;

    private String txnMicroCreditBeginDate;

    private String txnMicroCreditEndDate;

    private String corpNo;

    private String corpInd;

    private String superviseInd;

    private BigDecimal mortgageLoanBal;

    private BigDecimal beginMortgageLoanBal;

    private String activateBranch;

    private String preferStartDate;

    private String preferEndDate;

    private String ltdHighestAgeCd;

    private BigDecimal graceHighestBal;

    private String preferCd;

    private BigDecimal largeLoanXfrinBal;

    private String ddOtherBankInd;

    private Date creatTime;

    private Date udateTime;
}
