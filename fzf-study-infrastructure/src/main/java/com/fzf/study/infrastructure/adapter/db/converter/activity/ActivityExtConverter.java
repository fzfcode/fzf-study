package com.fzf.study.infrastructure.adapter.db.converter.activity;

import com.fzf.study.infrastructure.adapter.db.po.ActivityExtPO;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

/**
 * @author: SunKe
 * @date: 2020/9/12 11:04 上午
 * @description: 活动扩展信息转换器
 */
public class ActivityExtConverter {

    /**
     * 将活动扩展信息列表转换为以活动id和扩展类型的二元组作为key，活动扩展信息为value的map
     * @param activityExtPoList 活动扩展信息列表
     * @return Map(Pair(activityId, extType), ActivityExtPO)
     */
    public static ActivityExtPOWrapper convert2ActivityIdAndExtType4ActivityExtPOMap(List<ActivityExtPO> activityExtPoList) {
        if (CollectionUtils.isEmpty(activityExtPoList)) {
            return ActivityExtPOWrapper.builder()
                    .activityIdAndExtType4ActivityExtPoMap(Maps.newHashMap())
                    .build();
        }



        Map<Pair<Long, String>, ActivityExtPO> activityIdAndExtType4ActivityExtPoMap = Maps.newHashMap();
        activityExtPoList.forEach(activityExtPo ->
                activityIdAndExtType4ActivityExtPoMap.put(Pair.of(activityExtPo.getActivityId(), activityExtPo.getExtType()),
                        activityExtPo));

        return ActivityExtPOWrapper.builder()
                .activityIdAndExtType4ActivityExtPoMap(activityIdAndExtType4ActivityExtPoMap)
                .build();
    }
}
