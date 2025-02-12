package com.GinElmaC.redis.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class lettuce {
    public static void main(String[] args) {
        //使用构造器构造连接url
        RedisURI redisURI = RedisURI.builder()
                .withHost("192.168.88.130")
                .withPort(6379)
                .withAuthentication("default","111")
                .build();
        //创建redis客户端
        RedisClient redisClient = RedisClient.create(redisURI);
        //连接到redis客户端
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        //创建操作命令api
        RedisCommands<String, String> sync = connection.sync();

        sync.set("k5","v5");
        System.out.println(sync.ping());
    }
}
