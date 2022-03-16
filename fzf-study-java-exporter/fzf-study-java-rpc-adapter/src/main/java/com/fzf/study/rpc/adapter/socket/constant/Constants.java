package com.fzf.study.rpc.adapter.socket.constant;

public class Constants {


    public static final String MESSAGE_KEY = "MESSAGE_KEY";
    public static final int TXN_MODE_XML = 0;
    public static final String CHARSET_NAME_UTF8 = "UTF-8";

    //接口XML报文标签
    public static final String REQ_SERVICE_HEADER = "SERVICE_HEADER";
    public static final String REQ_SERVICE_BODY = "SERVICE_BODY";
    public static final String REQ_SERVICE_ID = "SERVICE_ID";
    public static final String MARKETING_SERVICE_ID = "MARKETING_SERVICE_ID";

    //接口请求交易编码
    public static final String QD_70001 = "70001";
    public static final String QD_90601 = "90601";
    public static final String QD_90602 = "90602";
    public static final String INSTALMENT_MSG_INVITE = "90605";

    //二维码邀请办卡数量统计接口
    public static final String QD_80001 = "80001";
    //二维码邀请办卡明细查询接口
    public static final String QD_80002 = "80002";
    //二维码邀请办卡数量统计接口--行员编号
    public static final String QD_80000_01 = "80000_01";
    //二维码邀请办卡明细查询接口--行员编号
    public static final String QD_80000_02 = "80000_02";

    //活动报名接口
    public static final String SIGN_UP_80101 = "80101";
    //活动报名查询接口
    public static final String SIGN_UP_80102 = "80102";

    //接口响应成功失败状态字
    public static final String RES_TYPE_SUCC = "S";
    public static final String RES_RTPE_FAIL = "F";

    //消息头
    public static final String HEAD = "head";
    //消息体
    public static final String BODY = "body";
    //卡片激活返回码
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    //卡片激活卡号
    public static final String CARD_NO = "CARD_NO";
    //诺曼底激活短信发送次数标识
    public static final String DATE_SCOPE_ONLYONE = "ONLYONE";
    //笔笔抽短信发送次数标识
    public static final String DATE_SCOPE_DAILY = "DAY";
}
