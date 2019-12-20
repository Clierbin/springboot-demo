package com.gupao.springbootdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:RedisUtil
 * Package:com.gupao.springbootdemo.util
 * description
 * Created by zhangbin on 12/20/2019.
 *
 * @author: zhangbin q243132465@163.com
 * @Version 1.0.0
 * @CreateTime： 12/20/2019 15:25
 */
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 是否存在key
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置指定 key 的值
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取指定 key 的值
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * 设置 key 的过期时间
     * @param key
     * @return
     */
    public Boolean setExpired(String key) {
        return redisTemplate.expire(key,30, TimeUnit.SECONDS);
    }
}
