package com.GinElmaC.Redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class login {
    @Autowired
    public RedisTemplate redisTemplate;

    @PostMapping("/login/set")
    public void loginHyperLogLog(){

    }
}
