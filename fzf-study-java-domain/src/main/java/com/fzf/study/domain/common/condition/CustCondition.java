package com.fzf.study.domain.common.condition;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/9/8 4:35 下午
 * @description: 客户达标条件
 */
@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
public class CustCondition implements ActivityCondition {

    /**
     * 是否有客户号限制
     */
    private Boolean hasCustNoLimit;

    /**
     * 客户号白名单文件
     */
    private List<String> custNoWhitelist;

    public static boolean isValidCustNo(String custNo) {
        if (!StringUtils.isNumeric(custNo)) {
            return false;
        }

        return custNo.length() <= 12;
    }
}
