package com.GinElmaC.Redis.Service.Impl;

import com.GinElmaC.Redis.Service.GuavaService;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuavaServiceImpl implements GuavaService {
    public static Integer _1W = 10000;
    public static Double fps = 0.3;
    public static Integer size = 10*_1W;
    public static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,fps);

    @Override
    public int GuavaCheck() {
        for(int i = 0;i<size;i++){
            bloomFilter.put(i);
        }
        List<Integer> list = new ArrayList<>(10*_1W);
        for(int i = size+1;i<10*_1W+size;i++){
            if(bloomFilter.mightContain(i)){
                list.add(i);
                System.out.println("错误查找");
            }
        }
        return list.size();
    }
}
