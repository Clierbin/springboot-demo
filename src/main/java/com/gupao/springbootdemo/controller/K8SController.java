package com.gupao.springbootdemo.controller;

import com.gupao.springbootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class K8SController {

    @RequestMapping("/k8s")
    public String k8s() {
        System.out.println("Hello K8s!!!");
        return "hello K8s Jack and zhangbin OK 666";
    }

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/redis")
    public String getKey(@RequestParam("key") String key) {
        System.out.println("进入到了Redis");
        if (!redisUtil.hasKey(key)) {
            redisUtil.set(key, "666");
            redisUtil.setExpired(key);
            return "没查到 + " + key;
        } else {

            return redisUtil.get(key);
        }
    }
}
