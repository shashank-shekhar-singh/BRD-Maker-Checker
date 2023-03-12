package com.ssnk.service;

import com.ssnk.dao.CustomerTempDao;
import com.ssnk.entity.CustomerTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTempServiceImpl implements CustomerTempService {
    @Autowired
    private CustomerTempDao customerTempDao;
    @Override
    public void insert(CustomerTemp customerTemp) {
        customerTempDao.insert(customerTemp);
    }

    @Override
    public void update(int id) {
        customerTempDao.update(id);
    }

    @Override
    public void delete(int id) {
        customerTempDao.delete(id);
    }

    @Override
    public List<CustomerTemp> getAll() {
        return customerTempDao.getAll();
    }

    @Override
    public CustomerTemp getCustomerTemp(int id) {
        return customerTempDao.getCustomerTemp(id);
    }
}
