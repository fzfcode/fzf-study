package com.fzf.study.dictionary.enums;

import lombok.Getter;

/**
 * @author: SunKe
 * @date: 2020/9/15 3:21 下午
 * @description: 操作类型枚举
 */
@Getter
public enum OperateTypeEnum {

    /**
     * 创建分期折扣活动
     */
    INSTALMENT_ADD("分期折扣活动创建"),

    /**
     * 更新分期折扣活动
     */
    INSTALMENT_UPDATE("分期折扣活动更新"),

    /**
     * 创建圈人活动
     */
    CUSTOMER_CROWD_ADD("圈人活动创建"),

    /**
     * 更新圈人活动
     */
    CUSTOMER_CROWD_UPDATE("圈人活动更新"),

    /**
     * 新增圈人活动的白名单
     */

    CUSTOMER_CROWD_ADD_WHITELIST("圈人活动白名单新增"),
    /**
     * 修改圈人活动的白名单
     */

    CUSTOMER_CROWD_UPDATE_WHITELIST("圈人活动白名单修改"),
    /**
     * 删除圈人活动的白名单
     */

    CUSTOMER_CROWD_DELETE_WHITELIST("圈人活动白名单删除")


    ;

    @Getter
    private String operateTypeDesc;

    OperateTypeEnum(String operateTypeDesc) {
        this.operateTypeDesc = operateTypeDesc;
    }

}
