package com.fzf.study.dictionary.rpc;

import java.io.Serializable;

/**
 * @author: SunKe
 * @date: 2020/9/3 7:40 下午
 * @description: 基础响应结果
 */
public abstract class BaseResponse implements Serializable {
    private static final long serialVersionUID = -8701420207990854315L;

    public static final int SUCCESS_CODE = 200;
    public static final int SYSTEM_CODE = 500;

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return code == SUCCESS_CODE;
    }
}
