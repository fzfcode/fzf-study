package com.fzf.study.starter.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/8 12:51 下午
 * @description:
 * @version: v1.0
 */
@Aspect
public class BenefitAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("execution(* com.fzf.study.starter.aop.Benefit.getBenefit(..))")
    public void benefit(){}

    @Around("benefit()")
    public void showBenefit(ProceedingJoinPoint joinPoint){
        try {
            logger.info("开始执行切面");
            List<String> result = (List<String>)joinPoint.proceed();
            for (String benefit : result) {
                logger.info("result：{}",benefit);
            }
            logger.info("切面执行完成");
        } catch (Throwable throwable) {
            logger.error("被通知方法执行异常");
        }
    }
}
