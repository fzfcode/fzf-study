package com.fzf.study.domain.common.record;


import com.fzf.study.dictionary.enums.OperateTypeEnum;

/**
 * @author: SunKe
 * @date: 2020/9/9 9:21 下午
 * @description: 活动更新日志Repository
 */
public interface ActivityChangeRecordRepository {

    /**
     * 新增活动更新记录
     * @param activityId 活动id
     * @param operateTypeEnum 操作类型
     * @param operator 操作人
     * @param content 内容
     */
    void add(Long activityId, OperateTypeEnum operateTypeEnum, String operator, String remark, Object... content);
}
