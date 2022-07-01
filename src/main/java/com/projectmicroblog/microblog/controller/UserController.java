package com.projectmicroblog.microblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.service.UserService;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserById")
    public User getUserById(@RequestParam(name = "userId") Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/getUserByHandle")
    public User getUserByUserName(@RequestParam(name = "userName") String handle) {
        return userService.findUserByHandle(handle);
    }

    @GetMapping("/isHandleAvailable")
    public boolean isUserNameAvailable(@RequestParam(name = "handle") String handle) {
        return userService.isHandleAvailable(handle);
    }

    @GetMapping("/isEmailAvailable")
    public boolean isEmailAvaialable(@RequestParam(name = "email") String email) {
        return userService.isEmailAvailable(email);
    }
}
