package com.ssnk.controller;

import com.ssnk.entity.CustomerTemp;
import com.ssnk.service.CustomerTempService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RestController
@Controller
@RequestMapping("tempCustomer")
public class CustomerTempController {

    private static final Logger logger = LogManager.getLogger(CustomerTempController.class);

    @Autowired
    private CustomerTempService customerTempService;

    @RequestMapping(path = "/add-new-customer", method = RequestMethod.GET)
    public String createNewCustomerForm(Model model) {
        model.addAttribute("title", "Add Customer");
        return "add_new_customer";
    }

    @RequestMapping(method= RequestMethod.POST,
            path="/create")
    public RedirectView createNewCustomer(@ModelAttribute CustomerTemp customerTemp, HttpServletRequest request) {
        customerTempService.insert(customerTemp);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }
//    public void registerCustomerTemp(@RequestBody CustomerTemp customerTemp){
//        customerTempService.insert(customerTemp);
//    }

    @RequestMapping(path="/delete/{id}")
    public RedirectView deleteNewCustomer(@PathVariable("id") int id, HttpServletRequest request){
        customerTempService.delete(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }

    @RequestMapping(path="/update/{id}")
    public String updateNewCustomerForm(@PathVariable("id") int id, Model model, HttpServletRequest request){
//        customerTempService.update(id);
        model.addAttribute("newCustomer", customerTempService.getCustomerTemp(id));
        return "update_new_customer";
    }

    @RequestMapping(method= RequestMethod.GET,
            path="/getAll")
    public List<CustomerTemp> getAllTempCustomers(){
        return customerTempService.getAll();
    }
}
