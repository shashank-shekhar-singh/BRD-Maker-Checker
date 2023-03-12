package com.ssnk.controller;

import com.ssnk.dao.UserDao;
import com.ssnk.entity.Customer;
import com.ssnk.entity.CustomerTemp;
import com.ssnk.entity.RecordStatus;
import com.ssnk.service.CustomerService;
import com.ssnk.service.CustomerTempService;
import com.ssnk.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RestController
@RequestMapping("checker")
public class CheckerController {

    private static final Logger logger = LogManager.getLogger(CheckerController.class);

    @Autowired
    CustomerTempService customerTempService;
    @Autowired
    UserDao userDao;
    @Autowired
    CustomerService customerService;

    @RequestMapping("/approve/{id}")
    public RedirectView approve(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        logger.info("Approving...");
        CustomerTemp customerTemp = customerTempService.getCustomerTemp(id);
        if(customerTemp != null) {
            if (customerTemp.getCreatedBy() != null && customerTemp.getCreatedBy().equals(Integer.toString(userDao.findUserByUsername(UserServiceImpl.getCurrentUsersUsername()).getUserId()))) {
                throw new Exception("Maker cannot be checker");
            }
            Customer customer = new Customer();
            customer.setFirstName(customerTemp.getFirstName());
            customer.setLastName(customerTemp.getLastName());
            customer.setAddress1(customerTemp.getAddress1());
            customer.setAddress2(customerTemp.getAddress2());
            customer.setPincode(customerTemp.getPincode());
            customer.setEmail(customerTemp.getEmail());
            customer.setContactNumber(customerTemp.getContactNumber());
            customer.setCreatedDate(customerTemp.getCreatedDate());
            customer.setCreatedBy(customerTemp.getCreatedBy());
            customer.setModifiedDate(customerTemp.getModifiedDate());
            customer.setModifiedBy(customerTemp.getModifiedBy());
            customer.setApprovedBy(Integer.toString(userDao.findUserByUsername(UserServiceImpl.getCurrentUsersUsername()).getUserId()));
            customer.setRecordStatus(RecordStatus.A);
            customerService.saveOrUpdate(customer);
            customerTempService.delete(customerTemp.getId());
        }
        else {
            Customer customer = customerService.getCustomer(id);
            if (customer.getRecordStatus().equals(RecordStatus.M)) {
                customer.setRecordStatus(RecordStatus.A);
                customerService.saveOrUpdate(customer);
            } else if (customer.getRecordStatus().equals(RecordStatus.D)) {
                customerService.delete(customer);
            }
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }

    @RequestMapping("/reject/{id}")
    public RedirectView reject(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        logger.info("Rejecting...");
        CustomerTemp customerTemp = customerTempService.getCustomerTemp(id);
        if(customerTemp != null) {
            if (customerTemp.getCreatedBy() != null && customerTemp.getCreatedBy().equals(Integer.toString(userDao.findUserByUsername(UserServiceImpl.getCurrentUsersUsername()).getUserId()))) {
                throw new Exception("Maker cannot be checker");
            }
            customerTemp.setRecordStatus(RecordStatus.R);
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }
}
