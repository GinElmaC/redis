package com.GinElmaC.Redis.Controller;

import com.GinElmaC.Redis.Service.GuavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuavaController {
    @Autowired
    private GuavaService guavaService;

    @GetMapping("/Guava")
    public String GuavaTest(){
        int res = guavaService.GuavaCheck();
        Double fps = (double)res/(10*10000);
        return "共有"+res+"个重复,"+"错误率约为"+fps;
    }

}
