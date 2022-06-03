package com.fzf.study.starter.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: fanzhenfeng
 * @date: 2022/3/31 11:45 上午
 * @description:
 * @version: v1.0
 */
@RestController
@RequestMapping("/test")
public class AopController {

    @Resource
    private Benefit benefit;

    @GetMapping("/getBenefit")
    public String getBenefit(){

        benefit.getBenefit();
        return "执行完成";
    }
}
