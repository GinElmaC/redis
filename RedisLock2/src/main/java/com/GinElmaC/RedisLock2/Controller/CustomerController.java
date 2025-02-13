package com.GinElmaC.RedisLock2.Controller;

import com.GinElmaC.RedisLock2.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //测试并发售卖，一次卖一个
    @GetMapping("/lock2/sold")
    public String soldTest(){
        return customerService.sold();
    }
}
