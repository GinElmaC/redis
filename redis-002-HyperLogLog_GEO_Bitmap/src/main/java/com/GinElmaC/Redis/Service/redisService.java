package com.GinElmaC.Redis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.commands.HyperLogLogCommands;

import javax.annotation.Resource;

@Service
public class redisService {
    @Autowired
    public RedisTemplate redisTemplate;

    public long uv(String key){
        return redisTemplate.opsForHyperLogLog().size(key);
    }
}
