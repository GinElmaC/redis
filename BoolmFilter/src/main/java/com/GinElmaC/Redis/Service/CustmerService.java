package com.GinElmaC.Redis.Service;

import com.GinElmaC.Redis.Bean.TCustomer;
import com.GinElmaC.Redis.Mapper.TCustomerTMapper;

public interface CustmerService{
    int addCuster(TCustomer customer);
    TCustomer findCuster(Integer CusterId);
}
