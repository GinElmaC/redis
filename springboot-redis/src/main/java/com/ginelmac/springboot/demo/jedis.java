//package com.ginelmac.springboot.demo;
//
//import redis.clients.jedis.Jedis;
//
//public class jedis {
//    public static void main(String[] args) {
//        //获得连接
//        Jedis jedis = new Jedis("192.168.88.130", 6379);
//        //填入密码
//        jedis.auth("111");
//        //测试连通性
//        System.out.println(jedis.ping());
//
//        //然后就可以进行一系列操作
//        jedis.set("k1","v1");
//        System.out.println(jedis.get("k1"));
//
//    }
//}
