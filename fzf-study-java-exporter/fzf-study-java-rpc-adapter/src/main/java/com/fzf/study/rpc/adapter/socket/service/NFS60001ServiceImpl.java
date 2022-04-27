package com.fzf.study.rpc.adapter.socket.service;

import com.fzf.study.application.support.bank.invitation.response.AccountInfoQueryReponse;
import com.fzf.study.infrastructure.adapter.db.mapper.AcctBaseInfoMapper;
import com.fzf.study.infrastructure.adapter.db.po.AcctInfoPO;
import com.fzf.study.rpc.adapter.socket.annotation.NFSServiceId;
import com.fzf.study.rpc.adapter.socket.constant.Constants;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.response.AccountInfoQuerySocketResponse;
import com.fzf.study.rpc.adapter.socket.util.DOMXMLReader;
import com.fzf.study.rpc.adapter.socket.util.RespXmlParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: fanzhenfeng
 * @date: 2022/4/24 9:06 下午
 * @description:
 * @version: v1.0
 */
@Service(Constants.QD_60001)
@NFSServiceId(type = Constants.QD_60001)
@Slf4j
public class NFS60001ServiceImpl implements NFSService {

    @Resource
    private AcctBaseInfoMapper acctBaseInfoMapper;

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {
//        按照账户号查询账户信息
        Integer acctNo = Integer.valueOf(domxmlReader.getValueFromReqServiceBody("ACCT_NO"));
        AcctInfoPO acctInfoPO = acctBaseInfoMapper.queryByAcctNo(acctNo);
        AccountInfoQueryReponse response = AccountInfoQueryReponse.builder()
                .acctNo(acctInfoPO.getAcctNo())
                .acctType(acctInfoPO.getAcctType())
                .blockCode(acctInfoPO.getBlockCode())
                .build();
        AccountInfoQuerySocketResponse socketResponse = new AccountInfoQuerySocketResponse();
        BeanUtils.copyProperties(response, socketResponse);
        return RespXmlParamUtil.getCoreMessage(domxmlReader, socketResponse, AccountInfoQuerySocketResponse.class);
    }
}
