package com.wayne.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Wayne
 * @date 2018/3/9
 * <p>
 * desc:redis工具类
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 无过期时间
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 以s为单位设置过期时间
     * @param key
     * @param value
     * @param second
     */
    private void setExpireBySecond(String key, String value, Long second) {
        redisTemplate.opsForValue().set(key, value, second, TimeUnit.SECONDS);
    }

    /**
     * 以min为单位设置过期时间
     * @param key
     * @param value
     * @param minute
     */
    private void setExpireByMinute(String key, String value, Long minute) {
        redisTemplate.opsForValue().set(key, value, minute, TimeUnit.MINUTES);
    }
    /**
     * 以h为单位设置过期时间
     * @param key
     * @param value
     * @param hours
     */
    private void setExpireByHours(String key, String value, Long hours) {
        redisTemplate.opsForValue().set(key, value, hours, TimeUnit.HOURS);
    }

    /**
     * 获取redis的数据
     * @param key
     * @return
     */
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除redis的数据
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
