/*
  Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.common;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhujianxun
 * @date: 2020/9/22 3:33 下午
 * @description: 数据处理Util
 */
public class DataUtils {
    /**
     * 短信内容封装
     * @param fieldArgs 属性对象
     * @param marketingSmsSuffix 短信模版
     * @param fields 属性
     * @param <T> 范型
     * @return String
     */
    public static <T> String replaceDynamicSmsValue(T fieldArgs, String marketingSmsSuffix, Field[] fields) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Field field : fields) {

            String fieldName = field.getName();
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = fieldArgs.getClass().getMethod(getter);
            Object value = method.invoke(fieldArgs);
            if (StringUtils.isBlank(value.toString())) {
                value = "";
            }
            marketingSmsSuffix = StringUtils.replace(marketingSmsSuffix, "${" + fieldName.toUpperCase() + "}", String.valueOf(value));
        }
        return marketingSmsSuffix;
    }
}
