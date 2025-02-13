package com.GinElmaC.RedisLock1.Controller;

import com.GinElmaC.RedisLock1.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //测试并发售卖，一次卖一个
    @GetMapping("/lock1/sold")
    public String soldTest(){
        return customerService.sold();
    }

    @GetMapping("/lock1/test")
    public String test(){
        return customerService.testLink();
    }
}
