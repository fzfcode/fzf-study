package com.fzf.study.rpc.adapter.socket.util;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.enums.ResponseAbstractEnum;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.request.RequestParamEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class RequestParamCheckUtil {


    public static CoreMessage checkParams(DOMXMLReader domxmlReader, RequestParamEnum... requestParamEnum) throws IOException, IllegalAccessException {

        if (requestParamEnum != null && requestParamEnum.length > 0) {
            for (RequestParamEnum paramEnum : requestParamEnum) {
                String paramName = domxmlReader.getValueFromReqServiceBody(paramEnum.getParamName());
                if (StringUtils.isBlank(paramName)) {
                    return RespXmlParamUtil.replyIllegalRequestOrParam(ResponseAbstractEnum.ILLEGALPARAM, domxmlReader, paramEnum.getErrorDesc());
                }
            }
        }
        return null;
    }
}
