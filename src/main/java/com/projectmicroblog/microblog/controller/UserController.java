package com.projectmicroblog.microblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.UserModel;
import com.projectmicroblog.microblog.service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody UserModel userModel) {
        return userService.saveUser(userModel);
    }

    @GetMapping("/getUserById")
    public User getUser(@RequestParam(name = "userId") Long userId) {
        return userService.findById(userId);
    }

    @GetMapping("/getByUserName")
    public User getUserByUserName(@RequestParam(name = "userName") String userName) {
        return userService.findByUserName(userName);
    }

    @GetMapping("/isUserNameAvailable")
    public boolean isUserNameAvailable(@RequestParam(name = "userName") String userName) {
        return userService.isUserNameAvailable(userName);
    }
}
