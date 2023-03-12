package com.ssnk.service;

import com.ssnk.dao.CustomerDao;
import com.ssnk.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public void saveOrUpdate(Customer customer) {
        customerDao.saveOrUpdate(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer getCustomer(long id) {
        return customerDao.getCustomer(id);
    }
}
