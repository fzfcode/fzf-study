package com.fzf.study.infrastructure.adapter.db.mapper.common;

import com.fzf.study.infrastructure.adapter.db.po.common.CardMediaInfoPO;
import org.apache.ibatis.annotations.Param;

public interface CardMediaInfoMapper {

    /**
     * 根据逻号查询卡片数量
     *
     * @param cardNo 卡号
     * @return 卡片数量
     */
    long countByCardNo(@Param("cardNo") String cardNo);

    /**
     * 新增卡片信息记录
     *
     * @param cardMediaInfoPO 卡片信息
     * @return 卡片梳理
     */
    long addCardMediaInfo(CardMediaInfoPO cardMediaInfoPO);

    /**
     * 更新卡片信息记录
     *
     * @param cardMediaInfoPO 卡片信息
     * @return 卡片梳理
     */
    long updateCardMediaInfo(@Param("record") CardMediaInfoPO cardMediaInfoPO);

}