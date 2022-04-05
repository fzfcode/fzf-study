package com.fzf.study.infrastructure.adapter.db.converter.activity;


import com.fzf.study.domain.common.AccountInfo;
import com.fzf.study.infrastructure.adapter.db.po.AcctInfoPO;

/**
 * @author fanglietao
 * @version 1.0
 * @date 2021/1/15 8:36 下午
 * @description
 */
public class AcctBaseInfoConverter {

    public static AccountInfo convert2CardBaseInfo(AcctInfoPO acctInfoPO) {
        if (acctInfoPO == null) {
            return null;
        }
        AccountInfo accountInfo = AccountInfo.builder()
                .acctNo(acctInfoPO.getAcctNo())
                .acctType(acctInfoPO.getAcctType())
                .blockCode(acctInfoPO.getBlockCode())
                .creditLimit(acctInfoPO.getCreditLimit())
                .ctdRetailAmt(acctInfoPO.getCtdRetailAmt())
                .ctdRetailCnt(acctInfoPO.getCtdRetailCnt())
                .currBal(acctInfoPO.getCurrBal())
                .currCd(acctInfoPO.getCurrCd())
                .custId(acctInfoPO.getCustId())
                .defaultLogicalCardNo(acctInfoPO.getDefaultLogicalCardNo())
                .graceDaysFullInd(acctInfoPO.getGraceDaysFullInd())
                .lastStmtDate(acctInfoPO.getLastStmtDate())
                .mobileNo(acctInfoPO.getMobileNo())
                .mtdRetailAmt(acctInfoPO.getMtdRetailAmt())
                .mtdRetailCnt(acctInfoPO.getMtdRetailCnt())
                .name(acctInfoPO.getName())
                .pmtDueDate(acctInfoPO.getPmtDueDate())
                .principalBal(acctInfoPO.getPrincipalBal())
                .productCd(acctInfoPO.getProductCd())
                .qualGraceBal(acctInfoPO.getQualGraceBal())
                .ytdRetailAmt(acctInfoPO.getYtdRetailAmt())
                .totDueAmt(acctInfoPO.getTotDueAmt())
                .ytdRetailCnt(acctInfoPO.getYtdRetailCnt())
                .build();
        return accountInfo;
    }
}
