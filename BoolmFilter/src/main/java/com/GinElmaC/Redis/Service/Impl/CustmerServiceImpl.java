package com.GinElmaC.Redis.Service.Impl;

import com.GinElmaC.Redis.Bean.TCustomer;
import com.GinElmaC.Redis.Mapper.TCustomerTMapper;
import com.GinElmaC.Redis.Service.CustmerService;
import com.GinElmaC.Redis.Utiles.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustmerServiceImpl implements CustmerService {
    public static String PRE_KEY = "custer:";

    @Autowired
    public TCustomerTMapper mapper;

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public CheckUtils checkUtils;

    @Override
    public int addCuster(TCustomer customer) {
        int res = mapper.insertSelective(customer);

        if(res > 0){
            //插入成功
            //数据回写进redis
            customer = mapper.selectByPrimaryKey(customer.getId());
            String key = PRE_KEY+String.valueOf(customer.getId());
            System.out.println(key);
            redisTemplate.opsForValue().set(key,customer);

            return 1;
        }
        return 0;
    }

    @Override
    public TCustomer findCuster(Integer CusterId) {
        TCustomer customer = null;
        String key = PRE_KEY+String.valueOf(CusterId);

        //布隆过滤器查询
        if(!checkUtils.checkwhite("white",key)){
            return null;
        }

        //redis查询
        customer = (TCustomer) redisTemplate.opsForValue().get(key);
        if(customer == null){
            //进入mysql查询
            customer = mapper.selectByPrimaryKey(CusterId);
            if(customer == null){
                //都没有
                return null;
            }
            redisTemplate.opsForValue().set(key,customer);
            return customer;
        }
        return customer;
    }
}
