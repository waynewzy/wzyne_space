package com.wayne.interceptor;

import com.wayne.model.User;
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
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user != null) {
            if (authToken.validate(user)) {
                return true;
            } else {
                request.getSession().removeAttribute("loginUser");
                response.sendRedirect("/login");
                return false;
            }
        }else{
            response.sendRedirect("/login");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
