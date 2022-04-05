/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.service;

import com.fzf.study.application.support.bank.invitation.request.CardInvitationInfoQueryRequest;
import com.fzf.study.application.support.bank.invitation.response.CardInvitationInfoQueryResponse;
import com.fzf.study.application.support.bank.invitation.service.CardApplyInvitationQueryService;
import com.fzf.study.common.BeanUtils;
import com.fzf.study.dictionary.enums.BankEmployeeFlagEnum;
import com.fzf.study.dictionary.enums.CardInvitationStatusTypeEnum;
import com.fzf.study.dictionary.enums.InvititationOptEnum;
import com.fzf.study.dictionary.exception.MktException;
import com.fzf.study.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.fzf.study.domain.common.MktActivityAssertUtils;
import com.fzf.study.rpc.adapter.socket.annotation.NFSServiceId;
import com.fzf.study.rpc.adapter.socket.constant.Constants;
import com.fzf.study.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.response.CardInvitationInfoQuerySocketResponse;
import com.fzf.study.rpc.adapter.socket.util.DOMXMLReader;
import com.fzf.study.rpc.adapter.socket.util.RespXmlParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: HouGang
 * @date: 2020-09-17 20:09:37
 * @description: 小程序二维码邀请办卡明细查询
 * @version: v1.0
 */

@Service(Constants.QD_80002)
@NFSServiceId(type = Constants.QD_80002)
@Slf4j
public class NFS80002ServiceImpl implements NFSService {

    @Resource
    CardApplyInvitationQueryService cardApplyInvitationQueryService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {
        String idNo = domxmlReader.getValueFromReqServiceBody("ID_NO");
        String status = domxmlReader.getValueFromReqServiceBody("STATUS");
        String searchType = domxmlReader.getValueFromReqServiceBody("SEARCH_TYPE");
        long firstRow = Long.parseLong(domxmlReader.getValueFromReqServiceBody("FIRSTROW"));
        long lastRow = Long.parseLong(domxmlReader.getValueFromReqServiceBody("LASTROW"));
        String bankEmployeeFlag = domxmlReader.getValueFromReqServiceBody("BANK_EMPLOYEEFLAG");
        String startDate = domxmlReader.getValueFromReqServiceBody("START_DATE");
        String endDate = domxmlReader.getValueFromReqServiceBody("END_DATE");
        bankEmployeeFlag = StringUtils.isBlank(bankEmployeeFlag) ? BankEmployeeFlagEnum.ALL.getCode() : bankEmployeeFlag;

        //build请求参数

        try {
            //校验时间参数并转换格式
            Date currStartDate = dateConversion(startDate,"S");
            Date currEndDate = dateConversion(endDate,"E");
            CardInvitationInfoQueryRequest request = buildRequest(idNo, status, searchType, firstRow, lastRow, bankEmployeeFlag, currStartDate, currEndDate);
            //请求参数校验
            checkRequest(request);

            CardInvitationInfoQueryResponse response = cardApplyInvitationQueryService.queryCardInvitationInfo(request);

            CardInvitationInfoQuerySocketResponse infoQuerySocketResponse = BeanUtils.clone(response, CardInvitationInfoQuerySocketResponse.class);
            infoQuerySocketResponse.setNextPageFlag(infoQuerySocketResponse.getLastRow() + 1 < infoQuerySocketResponse.getTotalRows() ? "Y" : "N");

            return RespXmlParamUtil.getCoreMessage(domxmlReader, infoQuerySocketResponse, CardInvitationInfoQuerySocketResponse.class);
        } catch (MktException mktException) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, mktException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("接口信息:{},请求信息:{},异常信息:{},", Constants.QD_80002, idNo, e);
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.SERVERROR, domxmlReader, "服务未知异常");
        }
    }

    private void checkRequest(CardInvitationInfoQueryRequest request)
            throws MktException {


        MktActivityAssertUtils.assertNotNull(request.getInviterNo(), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "证件号不能为空");

        MktActivityAssertUtils.assertNotNull(CardInvitationStatusTypeEnum.getSearchTypeByCode(
                request.getCardStatus()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "卡片状态有误");

        MktActivityAssertUtils.assertNotNull(InvititationOptEnum.getInvititationOptEnum(
                request.getSearchType()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "邀请性质有误[SEARCH_TYPE]");

        MktActivityAssertUtils.assertNotNull(BankEmployeeFlagEnum.getSearchBankEmployeeFlag(
                request.getBankEmployeeFlag()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "行员标识有误[BANK_EMPLOYEEFLAG]");

        long firstRow = request.getFirstRow();
        long lastRow = request.getLastRow();

        MktActivityAssertUtils.assertTrue(firstRow < lastRow, CommonResponseCodeEnum.FIRST_NOT_GREATER_LAST_ERROR);

        MktActivityAssertUtils.assertTrue(lastRow > 0, CommonResponseCodeEnum.LAST_NOT_LESS_EQUAL_ZERO_ERROR);

        MktActivityAssertUtils.assertTrue((lastRow - firstRow + 1) <= 10, CommonResponseCodeEnum.COUNT_NOT_GREATER_TEN_ERROR);

        if(request.getStartDate()!=null && request.getEndDate()!=null){
            long startDate = request.getStartDate().getTime();
            long endDate = request.getEndDate().getTime();
            MktActivityAssertUtils.assertTrue(startDate <= endDate,CommonResponseCodeEnum.START_NOT_GREATER_END_ERROR);

        }

    }


    private CardInvitationInfoQueryRequest buildRequest(String idNo, String status, String searchType, long firstRow, long lastRow, String bankEmployeeFlag, Date startDate, Date endDate)
            throws MktException {

        CardInvitationInfoQueryRequest request = new CardInvitationInfoQueryRequest();
        request.setInviterNo(idNo);
        request.setBankEmployeeFlag(bankEmployeeFlag);
        request.setCardStatus(status);
        request.setSearchType(searchType);
        request.setFirstRow(firstRow);
        request.setLastRow(lastRow);
        request.setStartDate(startDate);
        request.setEndDate(endDate);
        return request;

    }

    private Date dateConversion(String date,String status){
        Date dateReturn=null;
        if (date == null ||date.equals("")){
            if (status.equals("S")){
                // dateReturn=Date.from(LocalDate.MIN.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());

                log.info("开始日期为空或者null");
            }else {
                // dateReturn=Date.from(LocalDate.MAX.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
                log.info("结束日期为空或者null");
            }
        }
        else{
            //checkDate(date);
            try {
                simpleDateFormat.setLenient(false);
                dateReturn=simpleDateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                MktActivityAssertUtils.assertNotNull(null, CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "日期格式有误");
            }
        }
        return dateReturn;
    }
}
