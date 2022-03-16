package com.fzf.study.dictionary.enums;

/**
 * 分期折扣信息导入Enum
 */
public enum InstalmentDiscountImportEnum {
    SUCCESS("SUCCESS","成功"),
    FAIL_CHANNEL("FAIL","渠道号不能为空"),
    FAIL_DATE("FAIL","生效日期不能大于等于到期日期"),
    FAIL_LOAN_TYPE("FAIL","loanType校验失败"),
    FAIL_TERM("FAIL","最大期数小于最小期数"),
    FAIL_BATCH_DATE("FAIL","失效日期不能小于等于批量日期"),
    FAIL_CHECK_ACCT_NO("FAIL","账户号与证件号不匹配"),
    FAIL_CHECK_RATE("FAIL","折扣比例范围不正确"),
    FAIL_EXIT_RATE("FAIL","本批次已存在相同分期类型渠道的折扣信息"),
    FAIL_UNKNOWN("FAIL","字段不可为空、字段长度不可大于最大值或内容重复");

    /**
     * 状态
     */
    private String code;
    /**
     * 描述
     */
    private String desc;

    InstalmentDiscountImportEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
