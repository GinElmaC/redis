package com.ginelmac.springboot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {
    private static final String pre = "user:";
    @Resource
    private RedisTemplate redisTemplate;

    public void addOrder(){
        int keyId = ThreadLocalRandom.current().nextInt(1000)+1;
        String serialNo = UUID.randomUUID().toString();

        String key = pre+keyId;
        String value = "京东"+serialNo;

        redisTemplate.opsForValue().set(key,value);

        System.out.println(("key:" + key));
        System.out.println(("vlaue" + value));
    }

    public String getById(Integer id){
        String str = (String) redisTemplate.opsForValue().get(pre+id);
        return str;
    }
}
