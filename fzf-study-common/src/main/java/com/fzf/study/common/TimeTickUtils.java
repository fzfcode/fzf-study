package com.fzf.study.common;

public class TimeTickUtils {

    private Long sumTime;

    private Long prepareTime;

    private Long waitThreadPoolTime;


    private long start;

    private long lastTick;

    public TimeTickUtils() {
        start = System.currentTimeMillis();
    }

    public Long getSumTime() {
        return sumTime;
    }

    public void end() {
        this.sumTime = System.currentTimeMillis() - start;
    }

    public Long getPrepareTime() {
        return prepareTime;
    }

    public void endPrepare() {
        long t = System.currentTimeMillis();
        this.prepareTime = t - start;
        lastTick = t;
    }

    public Long getWaitThreadPoolTime() {
        return waitThreadPoolTime;
    }

    public void endWaitThreadPool() {
        long t = System.currentTimeMillis();
        this.waitThreadPoolTime = t - lastTick;
        lastTick = t;
    }


    @Override
    public String toString() {
        return new StringBuilder("sumCostTime:").append(sumTime)
                .append("[prepare:").append(prepareTime)
                .append(",saveOriginMessage:")
                .append("]").toString();
    }
}
