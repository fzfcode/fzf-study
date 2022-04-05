package com.fzf.study.dictionary.exception.error.code;


import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.ERROR;
import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.INFO;


/**
 * @author: SunKe
 * @date: 2020/9/11 11:41 上午
 * @description: 错误码范围枚举
 */
public enum CommonResponseCodeEnum implements BaseResponseCode {
    /**
     * 系统异常码段 9000-10000
     */
    SUCCESS(200, "成功", INFO),

    UNKNOWN_ERROR(500, "未知异常", ERROR),

    EMPTY_PARAM(700, "参数为空", ERROR),

    /**
     * 公用异常码段 10001-10500
     */
    ACTIVITY_NOT_EXIST(10002, "活动不存在", INFO),

    REQUEST_IS_NULL(10003, "请求不能为空", INFO),

    REQUEST_VALIDATE_ERROR(10004, "请求参数错误", INFO),
    INVALID_CARD_NO(10004, "无效的卡号", INFO),
    INVALID_ACTIVITY_ID(10004, "无效的活动或券ID", INFO),

    ACTIVITY_CLOSE(10001, "活动已关闭", INFO),

    FIRST_NOT_GREATER_LAST_ERROR(10005, "开始位置不能大于结束位置", INFO),

    LAST_NOT_LESS_EQUAL_ZERO_ERROR(10006, "结束位置不能小于等于0", INFO),

    COUNT_NOT_GREATER_TEN_ERROR(10007, "查询条数不能大于10条", INFO),

    START_NOT_GREATER_END_ERROR(10008, "开始日期不能大于结束日期", INFO),

    ACTIVITY_RULE_NOT_EXIST(10002, "活动规则未配置", INFO),

    CARD_NOT_APPLICABLE(10003, "卡号未达标", INFO),

    INVALID_ACTIVATE_DATE_LIMIT_RULE(10004, "无效的卡片激活时间限制规则", ERROR),

    ACTIVATE_DATE_NOT_APPLICABLE(10005, "卡片激活时间未达标", INFO),

    CUST_NOT_APPLICABLE(10006, "客户号未达标", INFO),

    INSTALMENT_AMOUNT_NOT_APPLICABLE(11006, "分期金额未达标", INFO),

    INSTALMENT_TYPE_NOT_APPLICABLE(11007, "分期类型未达标", INFO),

    CUSTOMER_HAS_INSTALMENT_BEFORE(11008, "客户已办理过分期业务", INFO),

    ACTIVITY_STATUS_NOT_VALID(11009, "活动当前为非有效状态", INFO),

    NOT_IN_ACTIVITY_VALID_TIME(11010, "不在活动有效期内", INFO),

    INVALID_ACTIVITY_CONDITION(11011, "无效的活动达标条件", INFO),

    INVALID_ACTIVITY_ACTION(11011, "无效的活动达标行为", INFO),

    ACTIVITY_PARTICIPATE_REQUEST_PROCESSED(11012, "活动参与请求已处理", INFO),

    CONFIRM_PARTICIPATE_STATUS_ERROR(11013, "确认活动参与状态失败", INFO),

    INVALID_PARTICIPATE_STATUS_ERROR(11014, "取消活动参与状态失败", INFO),

    VERIFY_VOUCHER_ERROR(11015, "核销权益凭证失败", INFO),

    INVALID_VOUCHER_ERROR(11016, "失效权益凭证失败", INFO),

    INSTALMENT_CHANNEL_NOT_APPLICABLE(11017, "分期渠道未达标", INFO),

    HAS_CUSTOMER_CONFIRM_NOT_APPLICABLE(11017, "需要客户报名未达标", INFO),

    HAS_WHITELIST_NOT_APPLICABLE(11018, "是否需要开启白名单未达标", INFO),

    SMS_SEND_DATE_NOT_APPLICABLE(11019, "短信发送日期未达标", INFO),

    MEMBER_TYPE_NOT_APPLICABLE(11020, "报名号类型未达标", INFO),

    MEMBER_NO_NOT_APPLICABLE(11021, "报名号未达标", INFO),

    SIGN_UP_DEAD_TIME_NOT_APPLICABLE(11022, "报名日期已截止", INFO),

    SMS_CONTENT_IS_NULL(11023, "短信内容不能为空", INFO),

    SIGN_UP_CHANNEL_NOT_APPLICABLE(11024, "活动报名渠道未达标", INFO),

    SIGN_UP_DATE_NOT_APPLICABLE(11025, "活动报名时间已截止", INFO),

    WHITELIST_NOT_APPLICABLE(11026, "白名单未达标", INFO),

    BATCH_NOT_PROCESS_COMPLETE(11026,"批量未处理完成",ERROR),

    PRODUCT_CODE_NOT_APPLICABLE(11028,"卡产品未达标", INFO),

    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 错误级别
     */
    private ErrorLogLevelEnum errorLogLevel;

    CommonResponseCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
        this.code = code;
        this.msg = msg;
        this.errorLogLevel = errorLogLevel;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public ErrorLogLevelEnum getErrorLogLevel() {
        return errorLogLevel;
    }

    @Override
    public String toString() {
        return "CommonResponseCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", errorLevel=" + errorLogLevel +
                '}';
    }
}
