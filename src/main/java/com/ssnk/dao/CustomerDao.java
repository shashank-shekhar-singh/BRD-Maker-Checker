package com.ssnk.dao;

import com.ssnk.entity.Customer;

import java.util.List;

public interface CustomerDao {
    void saveOrUpdate(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> getAll();
    Customer getCustomer(long id);
}
