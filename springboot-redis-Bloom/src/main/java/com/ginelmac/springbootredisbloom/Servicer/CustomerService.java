package com.ginelmac.springbootredisbloom.Servicer;

import com.ginelmac.springbootredisbloom.Bean.Customer;
import com.ginelmac.springbootredisbloom.Mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CustomerService {

    public static final String CAHCA="customer";
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private CustomerMapper customerMapper;

    public void add(Customer customer){
        int i = customerMapper.insert(customer);
        if(i>0){
            Customer res = customerMapper.selectByPrimaryKey(customer.getId());
            String key = CAHCA+customer.getId();
            redisTemplate.opsForValue().set(key,res);
        }
    }

    public Customer find(Integer id){
        String key = CAHCA+id;
        Customer customer1 = (Customer) redisTemplate.opsForValue().get(key);
        if(customer1 == null){
            customer1 = customerMapper.selectByPrimaryKey(id);
            if(customer1 != null){
                redisTemplate.opsForValue().set(key,customer1);
            }
        }
        return customer1;
    }
}
