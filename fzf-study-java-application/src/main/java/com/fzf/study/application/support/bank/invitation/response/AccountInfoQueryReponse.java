package com.fzf.study.application.support.bank.invitation.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author: fanzhenfeng
 * @date: 2022/4/24 9:35 下午
 * @description:
 * @version: v1.0
 */
@Data
@Builder
public class AccountInfoQueryReponse {
    private Integer acctNo;

    private String acctType;

    private Integer custId;

    private String blockCode;
}
