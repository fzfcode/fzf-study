package com.fzf.study.infrastructure.adapter.db.po;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: zhangheteng
 * @date: 2021-03-29 19:18
 * @description
 */
@Builder
@Data
public class InstalmentDiscountRatePO {

    private Integer id;

    private String org;

    private String acctNo;

    private String instalmentType;

    private String idNo;

    private BigDecimal rate;

    private Integer rateAdvanced;

    private String channelId;

    private Date startDate;

    private Date endDate;

    private Integer rateMaxTerm;

    private Integer rateMinTerm;

    private Date addTime;

    private Date updateTime;

    private String batchNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getInstalmentType() {
        return instalmentType;
    }

    public void setInstalmentType(String instalmentType) {
        this.instalmentType = instalmentType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getRateAdvanced() {
        return rateAdvanced;
    }

    public void setRateAdvanced(Integer rateAdvanced) {
        this.rateAdvanced = rateAdvanced;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getRateMaxTerm() {
        return rateMaxTerm;
    }

    public void setRateMaxTerm(Integer rateMaxTerm) {
        this.rateMaxTerm = rateMaxTerm;
    }

    public Integer getRateMinTerm() {
        return rateMinTerm;
    }

    public void setRateMinTerm(Integer rateMinTerm) {
        this.rateMinTerm = rateMinTerm;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
