package com.fzf.study.infrastructure.adapter.db.converter.activity;

import com.fzf.study.infrastructure.adapter.db.po.ActivityExtPO;
import lombok.Builder;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.Objects;

/**
 * @author: SunKe
 * @date: 2020/9/12 11:48 上午
 * @description: 活动扩展信息包装类
 */
@Builder
public class ActivityExtPOWrapper {

    /**
     * 以活动id和扩展类型的二元组作为key，活动扩展信息为value的map
     */
    private Map<Pair<Long, String>, ActivityExtPO> activityIdAndExtType4ActivityExtPoMap;

    public String getStringValue(Long activityId, String extType) {
        ActivityExtPO activityExtPo = activityIdAndExtType4ActivityExtPoMap.get(Pair.of(activityId, extType));
        if (Objects.isNull(activityExtPo)) {
            return "";
        }
        return activityExtPo.getExtDetail();
    }

    public Integer getIntegerValue(Long activityId, String extType) {
        ActivityExtPO activityExtPo = activityIdAndExtType4ActivityExtPoMap.get(Pair.of(activityId, extType));
        if (Objects.isNull(activityExtPo)) {
            return 0;
        }

        return Integer.valueOf(activityExtPo.getExtDetail());
    }
}
