package com.fzf.study.domain.common.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/15
 * @Version:
 * @Description:
 */

@Builder
@Data
public class CardBaseInfo {
    private Long acctNo;
    private Integer customerId;
    private String prodNo;
}
