/*
  Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.common;

import com.google.common.reflect.TypeToken;
import com.rits.cloning.Cloner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhujianxun
 * @date: 2020/9/17 7:58 下午
 * @description: Bean工具类
 */
public class BeanUtils {
    private static final Cloner cloner = new Cloner();

    /**
     * 复制对象（深度拷贝）
     * @param object 被拷贝对象
     * @param <T> 对象类型
     * @return T
     */
    public static <T> T clone(final T object){
        if (object == null) {
            return null;
        }
        return cloner.deepClone(object);
    }

    /**
     * 复制集合（深度拷贝）
     * @param object 被拷贝对象
     * @param <T> 对象类型
     * @return List<T>
     */
    public static <T> List<T> cloneList(final List<T> object){
        if (object == null) {
            return null;
        }
        return cloner.deepClone(object);
    }

    /**
     * 复制对象到指定类（深度拷贝）
     * @param object 被拷贝对象
     * @param clazz 指定类
     * @param <T> 目标对象类型
     * @return T
     */
    public static <T> T clone(final Object object, Class<T> clazz){
        if (object == null) {
            return null;
        }
        String json = GsonUtils.toJson(object);
        return GsonUtils.fromJson(json, clazz);
    }

    /**
     * 复制集合到指定类（深度拷贝）
     * @param object 被拷贝对象
     * @param clazz 指定类
     * @param <T> 目标对象类型
     * @return List<T>
     */
    public static <T> List<T> cloneList(List<?> object, Class<T> clazz) {
        if (object == null) {
            return new ArrayList<T>();
        }
        String json = GsonUtils.toJson(object);
        return GsonUtils.fromJson(json, new TypeToken<List<T>>() {});

    }

}
