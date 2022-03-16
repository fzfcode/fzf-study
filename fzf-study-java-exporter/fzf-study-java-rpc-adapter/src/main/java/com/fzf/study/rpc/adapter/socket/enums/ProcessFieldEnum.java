package com.fzf.study.rpc.adapter.socket.enums;

/**
 * @author hougang
 * @description 脱敏字段 type 选择处理方式 type为1：信用卡号，2：电话，3：身份证号, 4:姓名
 * @date 2020/3/26 20:59
 */
public enum ProcessFieldEnum {
    CARD_NO("CARD_NO","卡号",1),
    CUSTOMER_MOBILE("CUSTOMER_MOBILE","客户手机号",2),
    INVITEE_PHONE("INVITEE_PHONE","被邀请人手机号",2),
    ID_NO("ID_NO","证件号",3),
    INVITER_NAME("INVITER_NAME","邀请人姓名",4),
    INVITEE_NAME("INVITEE_NAME","被邀请人姓名",4),
    CUSTOMER_NAME("CUSTOMER_NAME","客户姓名",4),
    NAME_DTO("NAME","姓名",4),
    CELLPHONE_DTO("CELLPHONE","申请人手机",2),
    ID_NO_DTO("IDNO","证件号",3),
    CARDNO_NO_DTO("CARDNO","卡号",1);

    private String label;
    private String desc;
    private int type;

    ProcessFieldEnum(String label, String desc,int type) {
        this.label = label;
        this.desc = desc;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }
}
