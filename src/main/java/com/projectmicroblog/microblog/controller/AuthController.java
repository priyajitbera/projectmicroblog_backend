package com.projectmicroblog.microblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmicroblog.microblog.model.CredentialModel;
import com.projectmicroblog.microblog.model.JwtRequest;
import com.projectmicroblog.microblog.model.JwtResponse;
import com.projectmicroblog.microblog.service.AuthService;

@RestController
@RequestMapping("/rest/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(
            @RequestBody JwtRequest jwtRequest) {
        String token = authService.generateToken(jwtRequest.getUsername(), jwtRequest.getPassword());
        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public String register(@RequestBody CredentialModel credentialModel) {
        return authService.registerUser(credentialModel);
    }
}
