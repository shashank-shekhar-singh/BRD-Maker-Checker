package com.ssnk.controller;

import com.ssnk.entity.Customer;
import com.ssnk.entity.CustomerTemp;
import com.ssnk.entity.User;
import com.ssnk.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    CustomerTempService customerTempService;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    CurrentUser currentUser = CurrentUser.getCurrentUser();

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public RedirectView home(HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/home");
        return redirectView;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<CustomerTemp> customerTempList = customerTempService.getAll();
        model.addAttribute("tempCustomers", customerTempList);
        model.addAttribute("currentUserId", currentUser.id);
        model.addAttribute("isMaker", currentUser.isMaker);
        model.addAttribute("isChecker", currentUser.isChecker);
        model.addAttribute("isAdmin", currentUser.isAdmin);
        return "home";
    }

    @GetMapping("/authorized-customers")
    public String authorizedCustomers(Model model) {
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customers", customerList);
        model.addAttribute("currentUserId", currentUser.id);
        model.addAttribute("isMaker", currentUser.isMaker);
        model.addAttribute("isChecker", currentUser.isChecker);
        model.addAttribute("isAdmin", currentUser.isAdmin);
        return "authorized_customers";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        model.addAttribute("currentUserId", currentUser.id);
        model.addAttribute("isMaker", currentUser.isMaker);
        model.addAttribute("isChecker", currentUser.isChecker);
        model.addAttribute("isAdmin", currentUser.isAdmin);
        return "users";
    }

//    @RequestMapping(path = "/signup", method = RequestMethod.GET)
//    public String signup() {
//        return "signup";
//    }
}
