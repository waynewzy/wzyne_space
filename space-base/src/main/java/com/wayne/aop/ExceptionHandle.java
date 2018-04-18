package com.wayne.aop;

import com.wayne.exception.BusinessException;
import com.wayne.http.HttpUtil;
import com.wayne.http.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wayne
 * @date 2018/3/8
 * <p>
 * desc:异常统一处理
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response Handle(Exception ex) {
        if (ex instanceof BusinessException) {
            return HttpUtil.ResponseFail(((BusinessException) ex).getCode(), ex.getMessage());
        } else if (ex instanceof NullPointerException) {
            ex.printStackTrace();
            return HttpUtil.ResponseFail(500, "服务器繁忙");
        }
        ex.printStackTrace();
        return HttpUtil.ResponseFail(500, ex.getMessage());
    }
}
