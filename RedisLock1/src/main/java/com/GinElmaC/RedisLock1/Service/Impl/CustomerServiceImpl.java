package com.GinElmaC.RedisLock1.Service.Impl;

import com.GinElmaC.RedisLock1.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private RedisTemplate redisTemplate;

    //新建可重入锁
    private Lock lock = new ReentrantLock();

    @Override
    public String sold() {
        String res = "原本res";
        lock.lock();
        try {
            String restProject = String.valueOf(redisTemplate.opsForValue().get("project"));
            Integer rest = (restProject == null?0:Integer.valueOf(restProject));
            if(rest>0){
                rest--;
                redisTemplate.opsForValue().set("project",String.valueOf(rest));
                res = "线程1执行，还有"+rest+"张";
            }else{
                res = "售卖完毕";
            }
        } catch (NumberFormatException e) {
            res = "出错了，请联系工作人员";
        } finally {
            lock.unlock();
            return res;
        }
    }

    @Override
    public String testLink(){
        return String.valueOf(redisTemplate.opsForValue().get("project"));
    }
}
