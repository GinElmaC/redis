package com.GinElmaC.redis.RedisTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OneRedis {
    @Autowired
    private RedisTemplate redisTemplate;
//    private StringRedisTemplate stringRedisTemplate;

    public static String id_key = "order:";

    public void setOrderId(){
        int key = ThreadLocalRandom.current().nextInt(100)+1;
        String Id = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(id_key+Id,String.valueOf(key));
    }

    public String getOrderId(String Id){
        return (String)redisTemplate.opsForValue().get(id_key+Id);
    }
}
