package com.fzf.study.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: fanzhenfeng
 * @date: 2022/3/8 2:40 下午
 * @description:
 * @version: v1.0
 */
@SpringBootApplication(scanBasePackages = {"com.fzf.study"})
@MapperScan("**.mapper")
public class AppStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class,args);
    }
}
