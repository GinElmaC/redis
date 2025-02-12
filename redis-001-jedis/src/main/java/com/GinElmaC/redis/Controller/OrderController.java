package com.GinElmaC.redis.Controller;

import com.GinElmaC.redis.RedisTemplate.OneRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OneRedis oneRedis;

    @PostMapping("/order/set")
    public void setNewOrder(){
        System.out.println("111");
        oneRedis.setOrderId();
    }

    @GetMapping("/order/get/{id}")
    public String getOrder(@PathVariable("id") String id){
        return oneRedis.getOrderId(id);
    }
}
