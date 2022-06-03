package com.fzf.study.starter.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fanzhenfeng
 * @date: 2022/5/8 12:46 下午
 * @description:
 * @version: v1.0
 */
public class Benefit {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public List<String> getBenefit(){
        logger.info("开始执行业务逻辑");
        List<String> userBenefitList = new ArrayList<>();
        userBenefitList.add("红包");
        userBenefitList.add("折扣券");
        logger.info("执行业务逻辑完成");
        return userBenefitList;
    }

}
