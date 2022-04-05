package com.fzf.study.dictionary.exception.error.code;

public enum ResponseAbstractEnum {

    SUCCESS("SSSS","响应成功"),
    ILLEGALREQ("E001","请求非法"),
    ILLEGALPARAM("E002","参数非法"),
    SERVERROR("E004","服务端错误"),
    ACCEPTFAIL("E005","处理失败"),
    ORGNULL("E006","机构号不能为空"),
    ACCTNONULL("E006","账户号不能为空"),
    CHANNELNULL("E006","渠道不能为空"),
    LOANTYPENULL("E006","分期类型不能为空"),
    IDNONULL("E006","证件号不能为空"),
    RATETERMNULL("E006","分期期数不能为空"),
    INSTALMENT_OPERATE_TPYE_ERROR("E006","分期操作类型错误"),
    INSTALMENT_ACTIVITY_NOT_MATCHED("E006","分期活动达标异常"),
    INVALID_REQUEST("E006", "无效的分期请求"),
    ;

    public String resCode;
    public String descTitle;

    ResponseAbstractEnum(String resCode, String descTitle){
        this.resCode=resCode;
        this.descTitle=descTitle;
    }

    public static ResponseAbstractEnum getSearchError(String code){
        for(ResponseAbstractEnum type: ResponseAbstractEnum.values()){
            if(type.resCode.equals(code)){
                return type;
            }
        }
        return null;
    }
}
