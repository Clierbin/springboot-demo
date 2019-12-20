package com.gupao.springbootdemo.controller;

import com.gupao.springbootdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class K8SController {

    @RequestMapping("/k8s")
    public String k8s(){
        return "hello K8s Jack and zhangbin OK 666";
    }
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/redis")
    public String getKey(@RequestParam("key") String key){
        if(!redisUtil.hasKey(key)){
            redisUtil.set(key, "bearPotMan");
        }
        return redisUtil.get(key);
    }

}
