package com.ssnk.service;

import com.ssnk.entity.CustomerTemp;

import java.util.List;

public interface CustomerTempService {
    void insert(CustomerTemp customerTemp);
    void update(int id);
    void delete(int id);
    List<CustomerTemp> getAll();
    CustomerTemp getCustomerTemp(int id);
}
