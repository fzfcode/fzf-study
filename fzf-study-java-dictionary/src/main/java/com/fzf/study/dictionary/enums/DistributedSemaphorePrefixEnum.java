package com.fzf.study.dictionary.enums;

public enum DistributedSemaphorePrefixEnum {
    /**
     * 笔笔刷每日提醒
     */
    SMS_BBS_DAILY("SMS_BBS_DAILY", "笔笔刷每日提醒"),
    /**
     * 营销活动报名下行短信
     */
    SMS_ACTIVITY_DOWN("SMS_ACTIVITY_DOWN_", "营销活动报名下行短信"),
    /**
     * 批量同步卡账客文件
     */
    FILE_INFO_JOB_IMPORT("FILE_INFO_JOB_IMPORT_", "批量同步卡账客文件"),

    /**
     * 批量上传短信文件
     */
    SMS_BATCH_UPLOAD("SMS_BATCH_UPLOAD", "批量上传短信文件"),

    /**
     * 圈人活动短信批量文件上传
     */
    CUSTOMER_CROWD_SMS_BATCH_UPLOAD("CUSTOMER_CROWD_SMS_BATCH_UPLOAD_", "圈人活动短信批量文件上传"),

    /**
     * 批量生成账单分期下行营销短信记录
     */
    STMT_INSTALMENT_INVITE_MSG("STMT_INSTALMENT_INVITE_MSG_","批量生成账单分期下行营销短信记录"),

    /**
     * 完成批量生成账单分期下行营销短信记录
     */
    FINISH_STMT_INSTALMENT_INVITE_MSG("FINISH_STMT_INSTALMENT_INVITE_MSG_","完成批量生成账单分期下行营销短信记录"),

    /**
     * 批量账单分期下行营销短信发送
     */
    STMT_INSTALMENT_INVITE_MSG_SEND("STMT_INSTALMENT_INVITE_MSG_SEND_","批量账单分期营销短信发送"),


    /**
     * 分期折扣费率文件信息批量导入
     */
    INSTALMENT_DISCOUNT_FILE_IMPORT("INSTALMENT_DISCOUNT_FILE_IMPORT_", "分期折扣费率文件信息批量导入"),
    ;

    /**
     * 信号量前缀
     */
    private String prefix;

    /**
     * 描述
     */
    private String desc;

    DistributedSemaphorePrefixEnum(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
