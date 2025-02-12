package com.GinElmaC.Redis.Controller;

import com.GinElmaC.Redis.Bean.TCustomer;
import com.GinElmaC.Redis.Service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class CustomerController {
    @Autowired
    public CustmerService customerService;

    @PostMapping("/customer/add/{id}")
    public String addCustomer(@PathVariable("id") Integer id){
        TCustomer customer = new TCustomer();
        customer.setAge(18);
        customer.setCname("xiaoWang");
        customer.setId(id);
        customer.setSex(1);
        customer.setPhone("110");
        customer.setBirth(new Date());
        int res = customerService.addCuster(customer);
        if(res == 1){
            return "新增成功";
        }else{
            return "未知错误，新增失败";
        }
    }

    @GetMapping("/customer/find/{id}")
    public String findCustomer(@PathVariable("id") Integer id){
        TCustomer customer = null;
        customer = customerService.findCuster(id);
        if(customer == null){
            return "查询无";
        }else{
            return customer.toString();
        }
    }

    @GetMapping("/customer/test")
    public String test(){
        return "测试通过";
    }
}
