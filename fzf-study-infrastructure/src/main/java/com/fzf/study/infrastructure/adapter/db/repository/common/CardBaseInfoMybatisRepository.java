package com.fzf.study.infrastructure.adapter.db.repository.common;

import com.fzf.study.domain.common.model.CardBaseInfo;
import com.fzf.study.domain.common.repository.CardBaseInfoRepository;
import com.fzf.study.infrastructure.adapter.db.mapper.common.CardBaseInfoMapper;
import com.fzf.study.infrastructure.adapter.db.converter.common.CardBaseInfoConverter;
import com.fzf.study.infrastructure.adapter.db.po.common.CardBaseInfoPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: cepheus
 * @CreateTime: 2020/10/15
 * @Version:
 * @Description:
 */

@Repository("cardBaseInfoRepository")
@Slf4j
public class CardBaseInfoMybatisRepository implements CardBaseInfoRepository {
    @Resource
    private CardBaseInfoMapper cardBaseInfoMapper;

    public String getLogicalCardNoByAcctNoAndLatestCardNo(Integer acctNo, String latestCardNo) {
        CardBaseInfoPO cardBaseInfoPO = cardBaseInfoMapper.selectByAcctNoAndLatestCardNo(acctNo, latestCardNo);
        if (Objects.isNull(cardBaseInfoPO)) {
            return null;
        }
        return cardBaseInfoPO.getLogicalCardno();
    }

    public CardBaseInfo selectByLatestCardNo(String latestCardNo) {
        CardBaseInfoPO cardBaseInfoPO = cardBaseInfoMapper.selectByLatestCardNo(latestCardNo);
        return CardBaseInfoConverter.convertToCardBaseInfo(cardBaseInfoPO);
    }

    @Override
    public Date queryCardActivateDate(String cardNo) {
        CardBaseInfoPO cardBaseInfoPo = cardBaseInfoMapper.selectByLatestCardNo(cardNo);
        if (Objects.isNull(cardBaseInfoPo) || StringUtils.isBlank(cardBaseInfoPo.getActivateDate())) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(cardBaseInfoPo.getActivateDate());
        } catch (ParseException e) {
            log.warn("card activate date format error, cardNo: {}, activateDate: {} ", cardNo, cardBaseInfoPo.getActivateDate());
            return null;
        }
    }

}
