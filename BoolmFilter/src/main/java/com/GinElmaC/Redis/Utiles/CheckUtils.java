package com.GinElmaC.Redis.Utiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 检查过滤器中的内容
 */
@Component
public class CheckUtils {
    @Autowired
    public RedisTemplate redisTemplate;

    public boolean checkwhite(String white,String key){
        //获取输入的key对应的index
        int indexValue = Math.abs(key.hashCode());
        long index = (long)(indexValue % Math.pow(2,32));
        //取出bitmap中存的值
        Boolean bit = redisTemplate.opsForValue().getBit(white, index);
        //有，可能有
        if(bit){
            return true;
        }
        //没有，一定没有
        return false;
    }
}
