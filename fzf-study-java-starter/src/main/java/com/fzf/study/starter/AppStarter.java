package com.fzf.study.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: fanzhenfeng
 * @date: 2022/3/8 2:40 下午
 * @description:
 * @version: v1.0
 */
@SpringBootApplication(scanBasePackages = {"com.fzf.study"})
//@MapperScan("**.mapper")
@ImportResource("classpath:applicationContext.xml")
//@EnableCatClient
public class AppStarter {
    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class,args);
    }
}
