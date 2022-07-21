package com.projectmicroblog.microblog.controller;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {
    // @CrossOrigin(origins = "*")
    @GetMapping("/hello")
    public String hello() {
        return "Welcome! Micro Blogging application";
    }
}
