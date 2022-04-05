package com.fzf.study.dictionary.typehandler;

/**
 * @author: xuaimin
 * @date: 2020/10/13 上午11:15
 * @description: 枚举类型处理器
 */
public interface LabelAndValue<T> {

    String getLabel();

    T getValue();
}
