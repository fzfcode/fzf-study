package com.fzf.study.domain.common;

/**
 * 需要申请信号量的业务处理回调接口，如限制次数的短信发放方法
 */
public interface SemaphoreBizCallback<T> {

    /**
     * 业务回调方法
     * @return 业务方法执行结果
     */
    T execute() throws Exception;
}
