package com.projectmicroblog.microblog.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.Credential;
import com.projectmicroblog.microblog.repository.CredentialRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential credential = null;
        Optional<Credential> opt1 = credentialRepository.findByUserName(username);
        Optional<Credential> opt2 = credentialRepository.findByEmail(username);
        // find with actual userName
        if (opt1.isPresent()) {
            credential = opt1.get();
            System.out.println("***********************");
            System.out.println("loadUserByUserName() username=" + username);
            return new User(credential.getUserName(), credential.getPassword(), new ArrayList<>());

        }
        // find with email
        if (opt2.isPresent()) {
            credential = opt2.get();
            System.out.println("***********************");
            System.out.println("loadUserByUserName() username=" + username);
            return new User(credential.getEmail(), credential.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

    }
}
