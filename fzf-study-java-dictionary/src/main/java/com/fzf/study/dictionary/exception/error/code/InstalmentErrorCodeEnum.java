package com.fzf.study.dictionary.exception.error.code;

import com.fzf.study.dictionary.exception.BaseResponseCode;
import com.fzf.study.dictionary.exception.ErrorLogLevelEnum;

import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.ERROR;
import static com.fzf.study.dictionary.exception.ErrorLogLevelEnum.INFO;


/**
 * @Author: cepheus
 * @CreateTime: 2020/10/14
 * @Version:
 * @Description:
 */


public enum  InstalmentErrorCodeEnum implements BaseResponseCode {

    INSTALMENT_AMT_LESS_THAN_MIN_AMOUNT(10043, "不满足最小分期金额规则", INFO),
    QUERY_AVAILABLE_ACTIVITY_LIST(10044, "获取可用活动列表失败", INFO),
    REQUEST_INSTALMENT_TERM_IS_LIMITED(10045, "渠道端上送期数受到期数管控", INFO),
    REQUEST_INSTALMENT_AMT_IS_ILLEGAL(10046, "渠道端上送金额大于可分期金额", INFO),
    INSTALMENT_TERM_MATCH_RULE_NOT_EXIST(10047, "分期期数匹配规则不存在", INFO),
    INSTALMENT_TERM_MATCH_RULE_IS_NULL(10048, "分期期数匹配规则为空", INFO),
    INSTALMENT_AMT_MATCH_NO_TERM_RULE(10049, "可分期金额未匹配到分期期数", INFO),
    INVALID_CARD_NO(10050, "无效的卡号", ERROR),
    INSTALMENT_AMT_QUERY_FAILED(10051, "可分期金额查询失败", ERROR),
    INSTALMENT_PRE_CALCULATE_FAILED(10052, "分期试算失败", ERROR),
    INSTALMENT_DOWN_SMS_TEMPLATE_NOT_EXIST(10053, "下行短信模板不存在", ERROR),
    INSTALMENT_FAIL_SMS_TEMPLATE_NOT_EXIST(10054, "一键分期办理失败短信模板不存在", ERROR),
    INSTALMENT_BMP_SMS_TEMPLATE_NOT_EXIST(10055, "BMP短信模板不存在", ERROR),
    INSTALMENT_APPLY_FAIL(10056, "分期申请失败", ERROR),
    STATEMENT_INSTALMENT_FAIL_SMS_TEMPLATE_NOT_EXIST(10057, "账单分期办理失败短信模板不存在", ERROR),
    STATEMENT_INSTALMENT_SUCCESS_SMS_TEMPLATE_NOT_EXIST(10058, "账单分期办理成功短信模板不存在", ERROR),
    STATEMENT_INSTALMENT_INVITE_SMS_TEMPLATE_NOT_EXIST(10059, "账单分期下行短信模板不存在", ERROR),
    STATEMENT_INSTALMENT_INVITE_DISCOUNT_SMS_TEMPLATE_NOT_EXIST(10060, "账单分期下行折扣短信模板不存在", ERROR),
    STATEMENT_INSTALMENT_AMT_QUERY_FAILED(10061, "账单分期可分期金额查询失败", INFO),
    STATEMENT_INSTALMENT_PRE_CALCULATE_FAILED(10062, "账单分期分期试算失败", ERROR),
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

    InstalmentErrorCodeEnum(int code, String msg, ErrorLogLevelEnum errorLogLevel) {
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
        return "InstalmentErrorCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", errorLogLevel=" + errorLogLevel +
                '}';
    }
}
