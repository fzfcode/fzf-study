package com.fzf.study.rpc.adapter.socket.response;

import com.fzf.study.rpc.adapter.socket.annotation.RespXmlElement;
import lombok.Data;

/**
 * @author: fanzhenfeng
 * @date: 2022/4/24 9:27 下午
 * @description:
 * @version: v1.0
 */
@Data
@RespXmlElement(elementName = "")
public class AccountInfoQuerySocketResponse {
    @RespXmlElement(elementName = "ACCT_NO")
    private Integer acctNo;

    @RespXmlElement(elementName = "ACCT_TYPE")
    private String acctType;

    @RespXmlElement(elementName = "CUST_ID")
    private Integer custId;

    @RespXmlElement(elementName = "BLOCK_CODE")
    private String blockCode;


}
