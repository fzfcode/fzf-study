package com.fzf.study.infrastructure.adapter.db.mapper;

import com.fzf.study.infrastructure.adapter.db.po.AcctInfoPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author: zhujianxun
 * @date: 2020/9/29 11:32 上午
 * @description: 账户基础信息Mapper
 */
public interface AcctBaseInfoMapper {

    /**
     * 根据手机号查询任一账户
     *
     * @param mobileNo
     * @return
     */
    AcctInfoPO queryOneByMobileNo(@Param("mobileNo") String mobileNo);

    /**
     * 根据账号和账号类型查询账户
     *
     * @param acctNo
     * @return
     */
    AcctInfoPO queryByAcctNo(@Param("acctNo") Integer acctNo);



}
