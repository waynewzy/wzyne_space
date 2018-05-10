package com.wayne.interceptor;

import com.wayne.token.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wayne
 * @date 2018/3/8
 * <p>
 * desc: 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthToken authToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //执行拦截逻辑
        String token = request.getHeader("token");
        String requestURI = request.getRequestURI();
        if (requestURI.contains("login")) {
            return true;
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
