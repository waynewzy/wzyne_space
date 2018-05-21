package com.wayne.token;

import com.google.gson.Gson;
import com.wayne.model.User;
import com.wayne.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * @author wayne
 * @date 2018/5/8 0008
 * <p>
 * description: 校验token
 */
@Component
public class AuthToken {

    public static final String USER_LOGIN = "user_login";

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 验证token是否有效
     *
     * @param user
     * @return
     */
    public boolean validate(User user) {
        String sessionId = redisUtils.getValue(USER_LOGIN + user.getId());
        if (!StringUtils.isEmpty(sessionId) || sessionId.equals(user.getToken())) {
            return true;
        }
        return false;
    }
}
