package com.fzf.study.domain.common.record;

import com.fzf.study.dictionary.enums.OperateTypeEnum;
import lombok.Builder;

/**
 * @author: SunKe
 * @date: 2020/9/9 9:31 下午
 * @description: 活动更新记录
 */
@Builder
public class ActivityChangeRecord<T> {

    /**
     * 操作类型
     */
    private OperateTypeEnum operateTypeEnum;

    /**
     * 操作日志对象
     */
    private T operateLogObject;

    /**
     * 日志说明
     */
    private String remark;
}
