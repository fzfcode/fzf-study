package com.fzf.study.domain.common.condition;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/9/8 4:35 下午
 * @description: 卡片达标条件
 */
@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
public class CardCondition implements ActivityCondition {

    /**
     * 是否有卡号限制
     */
    private Boolean hasCardNoLimit;

    /**
     * 卡号白名单文件
     */
    private List<String> cardNoWhitelist;

    /**
     * 是否有卡片激活时间限制
     */
    private Boolean hasCardActivateTimeLimit;

    /**
     * 卡片最晚激活时间
     */
    private Date cardLatestActivateTime;

    public static boolean isValidCardNo(String cardNo) {
        if (!StringUtils.isNumeric(cardNo)) {
            return false;
        }

        return cardNo.length() == 16 || cardNo.length() == 19;
    }
}
