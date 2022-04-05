package com.fzf.study.common.batch;

import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/9/14 2:45 下午
 * @description: 批量插入模板回调函数
 */
public interface BatchExecuteCallback<T> {

    /**
     * 执行回调接口
     *
     * @param subList 分批处理的子列表
     * @return 批量处理条数
     */
    int execute(List<T> subList);
}
