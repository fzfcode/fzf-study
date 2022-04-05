package com.fzf.study.rpc.adapter.http;

import com.fzf.study.infrastructure.adapter.db.mapper.AcctBaseInfoMapper;
import com.fzf.study.infrastructure.adapter.db.po.AcctInfoPO;
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
public class Controller {

    @Resource
    private AcctBaseInfoMapper acctBaseInfoMapper;


    @GetMapping("/db/getData")
    public AcctInfoPO getDbdata(Integer acctNo){
        System.out.println("开始查询账户信息：" + acctNo);
        AcctInfoPO acctInfoPO = acctBaseInfoMapper.queryByAcctNo(acctNo);
//        System.out.println("AcctInfoPO:"+acctInfoPO);
        return acctInfoPO;
    }
}
