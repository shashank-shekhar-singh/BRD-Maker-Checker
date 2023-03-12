package com.ssnk.controller;

import com.ssnk.entity.Customer;
import com.ssnk.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
@RequestMapping("customer")
public class CustomerController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method= RequestMethod.POST,
            path="/create")
    public void registerCustomer(@RequestBody Customer customer){
        customerService.saveOrUpdate(customer);
    }

    @RequestMapping(method= RequestMethod.DELETE,
            path="/delete")
    public void deleteCustomer(@RequestBody Customer customer){
        customerService.delete(customer);
    }

    @RequestMapping(method= RequestMethod.POST,
            path="/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
    }

    @RequestMapping(method= RequestMethod.GET,
            path="/getAll")
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }
}
