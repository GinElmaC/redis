package com.ginelmac.springboot.Controller;

import com.ginelmac.springboot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("订单接口")
public class OrderContorller {
    @Resource
    private OrderService orderService;

    @PostMapping("/order/add")
    @ApiOperation("添加订单")
    public void addOrder(){
        orderService.addOrder();
    }

    @GetMapping("/order/{id}")
    @ApiOperation("根据id获取")
    public void getById(@PathVariable Integer id){
        orderService.getById(id);
    }
}
