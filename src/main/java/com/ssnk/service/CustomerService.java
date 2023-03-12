package com.ssnk.service;

import com.ssnk.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveOrUpdate(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> getAll();
    Customer getCustomer(long id);
}
