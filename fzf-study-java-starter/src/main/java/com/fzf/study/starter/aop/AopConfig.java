package com.fzf.study.starter.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/8 1:04 下午
 * @description:
 * @version: v1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public Benefit userBenefit(){
        System.out.println("创建benefit bean");
        return new Benefit();
    }

    @Bean
    public BenefitAspect benefitAspect(){
        System.out.println("创建benefitAspect bean");
        return new BenefitAspect();
    }
}
