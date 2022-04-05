package com.fzf.study.infrastructure.adapter.db.po;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: HouGang
 * @CreateTime: 2021-04-07 20:06:02
 * @Version: V1.0
 * @Description: 账单分期账户信息
 */

@Data
@Builder
public class StatementInstalmentAcctPO {

    /**
     * 账户号
     */
    private Integer acctNo;

    /**
     * 客户号
     */
    private Integer customerNo;

    /**
     * 账户类型
     */
    private String acctType;

    /**
     * 币种
     */
    private String currCd;

    /**
     * 全部应还款额
     */
    private BigDecimal qualGraceBal;

    /**
     * 最小应还款额
     */
    private BigDecimal totDueAmt;

    /**
     * 产品代码
     */
    private String productCd;

    /**
     * 默认逻辑卡号
     */
    private String defaultLogicalCardNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 最新介质卡号
     */
    private String latestCardNo;

    /**
     * 还款日
     */
    private String pmtDueDate;

    /**
     * 上个账单日
     */
    private String lastStmtDate;

    /**
     * 卡片锁定码
     */
    private String cardBlockCode;

    /**
     * 账户锁定码
     */
    private String acctBlockCode;

    /**
     * 手机号
     */
    private String mobileNo;


}