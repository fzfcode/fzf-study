package com.fzf.study.infrastructure.db.mapper.common;

import com.fzf.study.infrastructure.db.po.BatchSmsInfoPO;
import com.fzf.study.infrastructure.db.po.SmsTemplateFieldPO;
import com.fzf.study.infrastructure.db.po.common.CardBaseInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardBaseInfoMapper {

    CardBaseInfoPO selectByAcctNoAndLatestCardNo(@Param("acctNo") Integer acctNo, @Param("latestCardNo") String latestCardNo);

    CardBaseInfoPO selectByLatestCardNo(String latestCardNo);

    /**
     * 查询短信内容
     *
     * @param list 申请编号
     * @return List<BatchSmsInfoPO>
     */
    List<BatchSmsInfoPO> querySmsInfoByApplyNo(@Param("apply_no_list") List<String> list);

    /**
     * 查询短信模版的变量
     *
     * @param applyNo 申请编号
     * @return SmsTemplateFieldPO
     */
    SmsTemplateFieldPO querySmsTemplateFieldByApplyNo(@Param("applyNo") String applyNo);

    /**
     * 查询卡片基础信息
     *
     * @param applyNo 申请编号
     * @return CardBaseInfoPO
     */
    CardBaseInfoPO queryCardBaseInfoByApplyNo(@Param("applyNo") String applyNo);

    /**
     * 根据逻辑卡号查询卡片数量
     *
     * @param logicalCardNo 逻辑卡号
     * @return 卡片梳理
     */
    long countByLogicalCardNo(@Param("logicalCardNo") String logicalCardNo);

    /**
     * 新增卡片信息记录
     *
     * @param cardBaseInfoPO 卡片信息
     * @return 卡片梳理
     */
    long addCardBaseInfo(CardBaseInfoPO cardBaseInfoPO);

    /**
     * 更新卡片信息记录
     *
     * @param cardBaseInfoPO 卡片信息
     * @return 卡片梳理
     */
    long updateCardBaseInfo(@Param("record") CardBaseInfoPO cardBaseInfoPO);
}