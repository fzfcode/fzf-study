/**
 * Copyright (C) 2010 ~ 2021 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.domain.common.ExternalActivity;
import com.fzf.study.domain.common.ExternalActivityRepository;
import com.fzf.study.infrastructure.adapter.db.converter.activity.ExternalActivityConverter;
import com.fzf.study.infrastructure.adapter.db.mapper.common.MktExternalActivityMapper;
import com.fzf.study.infrastructure.adapter.db.po.common.ExternalActivityPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 11:12 上午
 * @description: 活动实体MybatisRepository
 */
@Repository("externalActivityRepository")
public class ExternalActivityMybatisRepository implements ExternalActivityRepository {
    @Resource
    private MktExternalActivityMapper mktExternalActivityMapper;

    @Override
    public ExternalActivity queryByType(String type) {
        ExternalActivityPO externalActivityPO = mktExternalActivityMapper.queryByType(type);
        return ExternalActivityConverter.convert2ExternalActivity(externalActivityPO);
    }
}
