package com.fzf.study.common.batch;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/9/14 2:45 下午
 * @description: 批量插入模板
 */
public class BatchExecuteTemplate {

    private static final int MAX_BATCH_SIZE = 50;

    public static <T> int executeBatchInsert(List<T> paramList, BatchExecuteCallback<T> callback) {
        //1. 校验
        if (CollectionUtils.isEmpty(paramList)) {
            return 0;
        }
        int listSize = paramList.size();

        //2. 分批执行
        int result = 0;
        int mod = listSize % MAX_BATCH_SIZE;
        int execCount = mod == 0 ? listSize / MAX_BATCH_SIZE : listSize / MAX_BATCH_SIZE + 1;
        for (int i = 0; i < execCount; i++) {
            if (i != execCount - 1) {
                result += callback.execute(paramList.subList(i * MAX_BATCH_SIZE, (i + 1) * MAX_BATCH_SIZE));
            } else {
                result += callback.execute(paramList.subList(i * MAX_BATCH_SIZE, listSize));
            }
        }

        return result;
    }
}
