package com.fzf.study.dictionary.enums;


public enum TradeInstalmentReplyFlagEnum {


    WAIT_COMMIT("0", "回复待处理"), COMMIT_SUCESS("1", "回复且分期成功"), COMMIT_FAIL("2", "回复且分期失败");

    private String replyFlag;
    private String desc;

    TradeInstalmentReplyFlagEnum(String replyFlag, String desc) {
        this.replyFlag = replyFlag;
        this.desc = desc;
    }

    public String getReplyFlag() {
        return replyFlag;
    }

    public void setReplyFlag(String replyFlag) {
        this.replyFlag = replyFlag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
