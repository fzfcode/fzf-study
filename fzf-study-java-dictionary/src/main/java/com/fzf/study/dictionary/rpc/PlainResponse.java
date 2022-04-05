package com.fzf.study.dictionary.rpc;

/**
 * @author: SunKe
 * @date: 2020/9/3 8:05 下午
 */
public class PlainResponse<T> extends BaseResponse {
    private static final long serialVersionUID = 422516874738490372L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
