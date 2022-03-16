package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: zhujianxun
 * @date: 2021/1/12 2:17 下午
 * @description:
 */
@Getter
public enum OperateLogEnum {
    SMS_UPDATE("短信模板修改"),
    SMS_ADD("短信模板新增"),
    ACTIVE_LABEL_UPDATE("激活短信标签修改"),
    ACTIVE_LABEL_ADD("激活短信标签新增"),
    INSTALMENT_ADD("分期折扣活动创建"),
    INSTALMENT_EDIT("分期折扣活动编辑修改"),
    INSTALMENT_WHITELIST_ADD("分期折扣活动白名单新增"),
    INSTALMENT_WHITELIST_UPDATE("分期折扣活动白名单修改"),
    INSTALMENT_WHITELIST_DELETE("分期折扣活动白名单删除");

    private String ruleDesc;

    OperateLogEnum(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }
}
