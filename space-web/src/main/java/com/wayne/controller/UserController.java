package com.wayne.controller;

import com.wayne.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wayne
 * @date 2018/5/18 0018 下午 17:33
 * <p>
 * description:
 */
@Controller
public class UserController {

    @RequestMapping("/toLogin")
    public String toLogin(User user) {
        System.out.println(user.getUsername());
        return "index";
    }
}
