package com.fzf.study.rpc.adapter.socket.request;

/**
 * @author hougang
 * @description 脱敏字段 type 选择处理方式 type为1：信用卡号，2：电话，3：身份证号, 4:姓名
 * @date 2020/3/26 20:59
 */
public enum RequestParamEnum {
    CARD_NO("CARD_NO","卡号不可为空",70000),
    CUTOMER_ID("CUTOMER_ID","客户ID不可为空",70000);


    private String paramName;
    private String errorDesc;
    private int type;

    RequestParamEnum(String paramName, String errorDesc, int type) {
        this.paramName = paramName;
        this.errorDesc = errorDesc;
        this.type = type;
    }

    public String getParamName() {
        return paramName;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public int getType() {
        return type;
    }
}
