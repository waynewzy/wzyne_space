package com.wayne.http;

/**
 * @author Wayne
 * @date 2018/3/9
 * <p>
 * desc: 接口返回结果工具类
 */
public class HttpUtil {

    /**
     * 响应成功无结果返回
     *
     * @return
     */
    public static Response ResponseSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(ResponseCode.RESPOND_SUCCESS.getCode());
        response.setMsg(ResponseCode.RESPOND_SUCCESS.getMsg());
        return response;
    }

    /**
     * 响应成功结果返回
     *
     * @param data
     * @return
     */
    public static Response ResponseSuccess(Object data) {
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(ResponseCode.RESPOND_SUCCESS.getCode());
        response.setMsg(ResponseCode.RESPOND_SUCCESS.getMsg());
        response.setResult(data);
        return response;
    }

    /**
     * 响应失败显示错误信息
     *
     * @param code 状态码
     * @param msg  错误信息
     * @return
     */
    public static Response ResponseFail(Integer code, String msg) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
