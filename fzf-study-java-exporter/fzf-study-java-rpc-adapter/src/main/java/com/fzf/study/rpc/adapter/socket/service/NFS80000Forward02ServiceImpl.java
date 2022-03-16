/**
 * Copyright (C) 2019 ~ 2020 MeiTuan. All Rights Reserved.
 */
package com.fzf.study.rpc.adapter.socket.service;

import com.alibaba.fastjson.JSON;
import com.sankuai.meituan.mkt.activity.application.support.bank.invitation.request.CardInvitationInfoQueryRequest;
import com.sankuai.meituan.mkt.activity.application.support.bank.invitation.response.CardInvitationInfoQueryResponse;
import com.sankuai.meituan.mkt.activity.application.support.bank.invitation.service.CardApplyInvitationQueryService;
import com.sankuai.meituan.mkt.activity.common.utils.BeanUtils;
import com.sankuai.meituan.mkt.activity.dictionary.enums.CardInvitationStatusTypeEnum;
import com.sankuai.meituan.mkt.activity.dictionary.enums.InvititationOptEnum;
import com.sankuai.meituan.mkt.activity.dictionary.exception.MktException;
import com.sankuai.meituan.mkt.activity.dictionary.exception.error.code.CommonResponseCodeEnum;
import com.sankuai.meituan.mkt.activity.domain.common.MktActivityAssertUtils;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.annotation.NFSServiceId;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.response.CardInvitationInfoQuerySocketResponse;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.RespXmlParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: HouGang
 * @date: 2020-09-17 20:09:37
 * @description: 小程序二维码邀请办卡明细查询
 * @version: v1.0
 */

@Service(Constants.QD_80000_02)
@NFSServiceId(type = Constants.QD_80000_02)
@Slf4j
public class NFS80000Forward02ServiceImpl implements NFSService {

    @Resource
    CardApplyInvitationQueryService cardApplyInvitationQueryService;

    @Override
    public CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException {


        String requestObject = domxmlReader.getValueFromReqServiceBody("REQUEST_OBJECT");

        if (StringUtils.isBlank(requestObject)) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader
                    , CommonResponseCodeEnum.REQUEST_IS_NULL.getMessage());
        }

        CardInvitationInfoQueryRequest queryEmployeeRequest = JSON.parseObject(requestObject, CardInvitationInfoQueryRequest.class);

        try {
            checkRequest(queryEmployeeRequest);

            CardInvitationInfoQueryResponse response = cardApplyInvitationQueryService.queryCardInvitationInfoByEmployeeNo(queryEmployeeRequest);

            CardInvitationInfoQuerySocketResponse infoQuerySocketResponse = BeanUtils.clone(response, CardInvitationInfoQuerySocketResponse.class);
            infoQuerySocketResponse.setNextPageFlag(infoQuerySocketResponse.getLastRow() + 1 < infoQuerySocketResponse.getTotalRows() ? "Y" : "N");

            return RespXmlParamUtil.getCoreMessage(domxmlReader, infoQuerySocketResponse, CardInvitationInfoQuerySocketResponse.class);
        } catch (MktException mktException) {
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, mktException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("接口信息:{},请求信息:{},异常信息:{},", Constants.QD_80000_02, requestObject, e);
            return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.SERVERROR, domxmlReader, "服务未知异常");
        }
    }


    private void checkRequest(CardInvitationInfoQueryRequest queryEmployeeRequest)
            throws MktException {

        long firstRow = queryEmployeeRequest.getFirstRow();
        long lastRow = queryEmployeeRequest.getLastRow();

        MktActivityAssertUtils.assertTrue(StringUtils.isNotBlank(queryEmployeeRequest.getBankEmployeeNo()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "行员编号不能为空");

        MktActivityAssertUtils.assertNotNull(CardInvitationStatusTypeEnum.getSearchTypeByCode(
                queryEmployeeRequest.getCardStatus()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "卡片状态有误");

        MktActivityAssertUtils.assertNotNull(InvititationOptEnum.getInvititationOptEnum(
                queryEmployeeRequest.getSearchType()), CommonResponseCodeEnum.REQUEST_VALIDATE_ERROR, "邀请性质有误[SEARCH_TYPE]");

        MktActivityAssertUtils.assertTrue(firstRow < lastRow, CommonResponseCodeEnum.FIRST_NOT_GREATER_LAST_ERROR);

        MktActivityAssertUtils.assertTrue(lastRow > 0, CommonResponseCodeEnum.LAST_NOT_LESS_EQUAL_ZERO_ERROR);

        MktActivityAssertUtils.assertTrue((lastRow - firstRow + 1) <= 10, CommonResponseCodeEnum.COUNT_NOT_GREATER_TEN_ERROR);

    }

}
