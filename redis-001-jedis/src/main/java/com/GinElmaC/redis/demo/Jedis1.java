package com.GinElmaC.redis.demo;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

public class Jedis1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.88.130",6379);
        jedis.auth("111");

        Set<String> keys = jedis.keys("*");
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = (String)iterator.next();
            System.out.println(key);
        }


    }
}
