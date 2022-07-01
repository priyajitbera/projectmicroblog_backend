package com.projectmicroblog.microblog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.Credential;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialService credentialService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // finds the credential using username(handle or email)
        // if not found throw exception
        Credential credential = null;
        try {
            credential = credentialService.findCredentialByHandleOrEmail(
                    username, username).get();
        } catch (Exception ex) {
            throw new UsernameNotFoundException(
                    "User not found with username: " + username);
        }
        return new User(username, credential.getPassword(), new ArrayList<>());
    }
}
