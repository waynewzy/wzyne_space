package com.wayne.controller;

import com.google.gson.Gson;
import com.sun.tools.internal.ws.wsdl.document.http.HTTPUrlReplacement;
import com.wayne.http.HttpUtil;
import com.wayne.model.User;
import com.wayne.redis.RedisUtils;
import com.wayne.service.api.UserService;
import com.wayne.token.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wayne
 * @date 2018/5/18 0018 下午 17:33
 * <p>
 * description:
 */
@Controller("/user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/toLogin")
    public String toLogin(User user) {
        user = userService.findByPhoneAndPassword(user);
        if (user == null) {
            request.setAttribute("msg", "用户名与密码不正确");
            return "login";
        } else {
            request.getSession().setAttribute("loginUser",user);
            user.setToken(request.getSession().getId());
            userService.update(user);
            redisUtils.setValue(AuthToken.USER_LOGIN + user.getId(),user.getToken());
            return "index";
        }
    }
}
