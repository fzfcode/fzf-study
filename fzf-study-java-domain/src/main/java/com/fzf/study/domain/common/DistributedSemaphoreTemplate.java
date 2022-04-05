package com.fzf.study.domain.common;


import com.fzf.study.dictionary.enums.DistributedSemaphorePrefixEnum;

public interface DistributedSemaphoreTemplate {

    /**
     * 使用分布式信号量模板方法
     * @param semaphorePrefixEnum 分布式信号量枚举
     * @param requestId 请求ID（信号量枚举下唯一）
     * @param initPermitsNum 初始许可证数量
     * @param retryTimes 获取信号量失败重试次数
     * @param callback 业务回调方法
     * @return 业务回调方法执行结果
     */
    <T> T execute(DistributedSemaphorePrefixEnum semaphorePrefixEnum, String requestId,
                  int initPermitsNum, int retryTimes,
                  SemaphoreBizCallback<T> callback) throws Exception;

    /**
     * 获取一个信号量
     * @param semaphorePrefixEnum 分布式信号量枚举
     * @param requestId 请求ID（信号量枚举下唯一）
     * @param initPermitsNum 可申请许可数量
     * @param retryTimes 获取失败重试次数
     * @return 是否获取成功
     */
    boolean tryAcquire(DistributedSemaphorePrefixEnum semaphorePrefixEnum, String requestId,
                       int initPermitsNum, int retryTimes);

    /**
     * 释放一个信号量
     * @param semaphorePrefixEnum 分布式信号量枚举
     * @param requestId 请求ID（信号量枚举下唯一）
     * @param retryTimes 释放失败重试次数
     * @return 是否释放成功
     */
    boolean tryRelease(DistributedSemaphorePrefixEnum semaphorePrefixEnum, String requestId, int retryTimes);
}
