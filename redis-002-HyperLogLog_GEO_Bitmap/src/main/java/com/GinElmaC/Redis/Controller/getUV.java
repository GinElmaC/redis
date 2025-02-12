package com.GinElmaC.Redis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.commands.HyperLogLogCommands;
import com.GinElmaC.Redis.Service.redisService;

import javax.annotation.Resource;

@RestController
public class getUV {
    @Autowired
    private redisService redisService;

    @GetMapping("/getuv/{key}")
    public long UV(@PathVariable("key") String key){
        return redisService.uv(key);
    }
}
