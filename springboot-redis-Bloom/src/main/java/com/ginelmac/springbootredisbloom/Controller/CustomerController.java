package com.ginelmac.springbootredisbloom.Controller;

import com.ginelmac.springbootredisbloom.Bean.Customer;
import com.ginelmac.springbootredisbloom.Servicer.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

@RestController
@Slf4j
@Api("用户接口")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @ApiOperation("数据库初始化两条")
    @PostMapping("/customer/add")
    public void add(){
        for (int i =0 ;i<2;i++) {
            Customer customer = new Customer();

            customer.setAge(i*2);
            customer.setSex((byte)new Random().nextInt(2));
            customer.setCname("cucu"+i);
            customer.setPhone("111"+i);
            customer.setBirth(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

            customerService.add(customer);
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("/customer/{id}")
    public Customer get(@PathVariable Integer id){
        return customerService.find(id);
    }
}
