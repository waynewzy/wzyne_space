package com.wayne.http;

/**
 * @author Wayne
 * @date 2018/3/9
 * <p>
 * desc: 响应状态码
 */
public enum ResponseCode {

    /**
     * 状态码以及错误信息
     */
    RESPOND_SUCCESS(0,"请求成功"),
    RESPOND_USER_NOT_REGISTER(1,"用户未注册"),
    RESPOND_GET_DATA_FAIL(1001,"请求失败"),
    RESPOND_TOKEN_NULL_FAIL(1002,"token为空"),
    RESPOND_TOKEN_INVALID_FAIL(1003,"token失效");


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
