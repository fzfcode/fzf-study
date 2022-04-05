package com.fzf.study.dictionary.rpc;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: SunKe
 * @date: 2020/10/14 7:54 下午
 * @description: 分页对象
 */
@Data
@Builder
public class Paginator<T> implements Serializable {
    private static final long serialVersionUID = -2210917826350183377L;
    /**
     * 总数
     */
    private int total;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 数据列表
     */
    private List<T> list;

    public boolean isEmpty() {
        return total == 0;
    }

    public static <T> Paginator<T> buildEmptyResponse(int pageNum, int pageSize) {
        return buildEmptyResponse(pageNum, pageSize, 0);
    }

    public static <T> Paginator<T> buildEmptyResponse(int pageNum, int pageSize, int total) {
        return Paginator.<T>builder()
                .pageNum(pageNum)
                .pageSize(pageSize)
                .total(total)
                .list(new ArrayList<>())
                .build();
    }

    public static int getStartIndex(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return 0;
        }

        int startIndex = pageSize * (pageNum - 1);

        if (startIndex < 0) {
            return 0;
        }

        return startIndex;
    }

}
