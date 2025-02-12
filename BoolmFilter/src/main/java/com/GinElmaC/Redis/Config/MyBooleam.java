package com.GinElmaC.Redis.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 布隆过滤器自定义
 */
@Component
public class MyBooleam {
    @Autowired
    public RedisTemplate redisTemplate;

    @PostConstruct
    public void initWhite(){
        //自定义一个白名单账号
        String customer = "custer:7";
        //获取对应的hash值
        int hash = Math.abs(customer.hashCode());
        long index = (long) ((long)hash % (Math.pow(2,32)));
        //设置白名单
        redisTemplate.opsForValue().setBit("white",index,true);

        System.out.println("白名单初始化完毕");
    }
}
