package com.ssnk.controller;

import com.ssnk.entity.User;
import com.ssnk.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
//    public void registerUser(@ModelAttribute User user) {
//        userService.insert(user);
//    }

    @RequestMapping(method= RequestMethod.POST,
            path="/register")
    public void registerUser(@RequestBody User user){
        userService.insert(user);
    }

    @RequestMapping(method= RequestMethod.DELETE,
            path="/delete")
    public void deleteUser(@RequestBody User user){
        userService.delete(user);
    }

    @RequestMapping(method= RequestMethod.PUT,
            path="/update")
    public void updateUser(@RequestBody User user){
        userService.update(user);
    }

    @RequestMapping(method= RequestMethod.GET,
            path="/getAll")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @RequestMapping(method= RequestMethod.GET,
            path="/getDetails/{id}")
    public User getUserDetails(@PathVariable("id") int id){
        return userService.getUser(id);
    }
}
