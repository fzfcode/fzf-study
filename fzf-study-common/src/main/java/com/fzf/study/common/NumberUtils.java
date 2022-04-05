package com.fzf.study.common;

import java.math.BigDecimal;

/**
 * @author: SunKe
 * @date: 2020/10/19 2:56 下午
 * @description: 数值工具类
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils {

    public static boolean isBiggerThan(Integer value, int target) {
        if (value == null) {
            return false;
        }

        return value > target;
    }

    public static boolean isBiggerThan(Long value, long target) {
        if (value == null) {
            return false;
        }

        return value > target;
    }

    public static boolean isLessThan(Integer value, int target) {
        if (value == null) {
            return false;
        }

        return value < target;
    }

    public static boolean isLargeThanZero(Long number) {
        return number != null && number > 0;
    }

    public static boolean isLargeThanZero(Integer number) {
        return number != null && number > 0;
    }


    public static boolean isLargeThanZero(BigDecimal number) {
        return number != null && number.compareTo(BigDecimal.ZERO) > 0;
    }
}
