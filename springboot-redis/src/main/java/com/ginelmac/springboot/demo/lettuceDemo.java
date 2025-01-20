//package com.ginelmac.springboot.demo;
//
//
//import io.lettuce.core.RedisClient;
//import io.lettuce.core.RedisURI;
//import io.lettuce.core.api.StatefulRedisConnection;
//import io.lettuce.core.api.sync.RedisCommands;
//
//public class lettuceDemo {
//    public static void main(String[] args) {
//        //lettuce需要使用构建器链式编程
//        RedisURI root = RedisURI.builder()
//                .redis("192.168.88.130")
//                .withPort(6379)
//                .withAuthentication("root", "111").build();
//        //连接客户端
//        RedisClient redisClient = RedisClient.create(root);
//        StatefulRedisConnection conn = redisClient.connect();
//        //通过connect创建操作的command
//        RedisCommands command = conn.sync();
//
//        //进行操作
//
//        //关闭资源
//        conn.close();
//        redisClient.close();
//    }
//}
