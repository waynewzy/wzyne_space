package com.wayne.token;

import com.wayne.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wayne
 * @date 2018/5/8 0008
 * <p>
 * description: 校验token
 */
@Component
public class AuthToken {

    @Autowired
    private RedisUtils redisUtils;


}
