package com.fzf.study.rpc.adapter.socket.enums;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.constant.Constants;

public enum ResponseAbstractEnum {

    SUCCESS(Constants.RES_TYPE_SUCC, "SSSS", "响应成功"),
    ILLEGALREQ(Constants.RES_RTPE_FAIL, "E001", "请求非法"),
    ILLEGALPARAM(Constants.RES_RTPE_FAIL, "E002", "参数非法"),
    SERVERROR(Constants.RES_RTPE_FAIL, "E004", "服务端错误");


    public String resType;
    public String resCode;
    public String descTitle;

    ResponseAbstractEnum(String resType, String resCode, String descTitle) {
        this.resType = resType;
        this.resCode = resCode;
        this.descTitle = descTitle;
    }

}
