package com.fzf.study.common;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/14 2:45 下午
 * @description: 空值检查工具类
 */
public class NullCheckUtils {
    /**
     * 检查对象是否都为空
     *
     * @param objs 检查对象
     */
    public static boolean checkIsAllNull(Object... objs) {
        for (Object obj : objs) {
            if (obj instanceof Collection) {
                if (CollectionUtils.isNotEmpty((Collection) obj)) {
                    return false;
                }
            } else if (obj instanceof Map) {
                if (MapUtils.isNotEmpty((Map) obj)) {
                    return false;
                }
            } else if (obj != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查对象是否都非空
     *
     * @param objs 检查对象
     */
    public static boolean checkIsAllNotNull(Object... objs) {
        for (Object obj : objs) {
            if (obj instanceof Collection) {
                if (CollectionUtils.isEmpty((Collection) obj)) {
                    return false;
                }
            } else if (obj instanceof Map) {
                if (MapUtils.isEmpty((Map) obj)) {
                    return false;
                }
            } else if (obj == null) {
                return false;
            }
        }
        return true;
    }

    private NullCheckUtils() {
        // utility class
    }
}
