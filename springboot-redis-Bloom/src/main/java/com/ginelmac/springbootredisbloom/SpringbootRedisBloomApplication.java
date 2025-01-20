package com.ginelmac.springbootredisbloom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.ginelmac.springbootredisbloom.Mapper")
public class SpringbootRedisBloomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisBloomApplication.class, args);
    }

}
