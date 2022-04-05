/**
 * CopyRight (C) 2019 ~ 2021 MeiTuan. All Rights Reserved
 */
package com.fzf.study.domain.common;

/**
 * @author: cuijiong
 * @date: 2021/4/12 20:24
 * @description: 埋点监控
 * @version: v1.0
 */
public interface MetricMonitor {
    void logMetricForCount(String name);
}
