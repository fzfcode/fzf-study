package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2020/9/15 5:38 下午
 * @description: 外部活动类型
 */
public enum ExternalActivityTypeEnum {
    /**
     * 激活派单
     */
    ACTIVE_DISPATCH("激活派单", "ActiveDispatch"),

    QD_CARD_INVITATION("小程序二维码邀请办卡", "CardInvitation");

    @Getter
    private String activityDesc;

    @Getter
    private String activityType;

    ExternalActivityTypeEnum(String activityDesc, String activityType) {
        this.activityDesc = activityDesc;
        this.activityType = activityType;
    }
}
