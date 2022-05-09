package com.fzf.study.starter.schedule.springboot;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/9 1:04 下午
 * @description:
 * @version: v1.0
 */
@Component
@Log4j2
public class ScheduledTask {
    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() throws InterruptedException {
        log.info("I am task11111111, current thread: {}", Thread.currentThread());
        while (true) {
            //模拟耗时任务，阻塞10s
            Thread.sleep(10000);
            break;
        }
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void task2() {
        log.info("I am task22222222, current thread: {}", Thread.currentThread());
    }
}
