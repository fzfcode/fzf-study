/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.response;

import com.fzf.study.rpc.adapter.socket.annotation.RespXmlElement;
import com.fzf.study.rpc.adapter.socket.annotation.RespXmlListElement;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/17 4:17 下午
 * @description: 卡片信息查询SocketResponse
 */
@RespXmlElement(elementName = "")
@Getter
@Setter
public class CardApplyInfoInquirySocketResponse {
    @RespXmlElement(elementName = "TOTAL_ROWS")
    private Integer totalRows;

    @RespXmlListElement(elementName = "APPLY_INFO_LIST", subType = CardApplyInfoInquirySocketResponse.ApplyInfo.class)
    private List<ApplyInfo> applyList = new ArrayList<>();

    @RespXmlElement(elementName = "APPLY_INFO")
    @Setter
    @Getter
    public static class ApplyInfo {
        @RespXmlElement(elementName = "APPLY_NO")
        private String applyNo;
        @RespXmlElement(elementName = "CARD_NO")
        private String cardNo;
        @RespXmlElement(elementName = "CARD_NAME")
        private String cardName;
        @RespXmlElement(elementName = "BANK_NAME")
        private String bankName;
        @RespXmlElement(elementName = "CHECK_DATE")
        private String checkDate;
        @RespXmlElement(elementName = "CUSTOMER_NAME")
        private String customerName;
        @RespXmlElement(elementName = "CUSTOMER_MOBILE")
        private String customerMobile;
        @RespXmlElement(elementName = "MAIL_PROVINCE")
        private String mailProvince;
        @RespXmlElement(elementName = "MAIL_CITY")
        private String mailCity;
        @RespXmlElement(elementName = "MAIL_REGION")
        private String mailRegion;
        @RespXmlElement(elementName = "MAIL_DETAIL_ADDRESS")
        private String mailDetailAddress;
        @RespXmlElement(elementName = "CUSTOMER_BIRTHDAY")
        private String customerBirthday;
        @RespXmlElement(elementName = "CUSTOMER_GENDER")
        private String customerGender;
        @RespXmlElement(elementName = "REMARK")
        private String remark;
        @RespXmlElement(elementName = "CREDIT_LIMIT")
        private String creditLimit;
        @RespXmlElement(elementName = "CREDIT_LIMIT_CODE")
        private String creditLimitCode;
        @RespXmlElement(elementName = "FACE_SIGN_FLAG")
        private String blockCode;
    }
}
