package com.projectmicroblog.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.Credential;
import com.projectmicroblog.microblog.model.CredentialModel;
import com.projectmicroblog.microblog.model.UserModel;
import com.projectmicroblog.microblog.repository.CredentialRepository;

@Service
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void saveCredential(CredentialModel credentialModel) {
        // create and save a new credential
        Credential credential = Credential.builder()
                .userName(credentialModel.getUserName())
                .email(credentialModel.getEmail())
                .password(passwordEncoder.encode(credentialModel.getPassword()))
                .build();
        credential = credentialRepository.save(credential);
        // create userModel from using details credentialModel and save a new User
        UserModel userModel = UserModel.builder()
                .userName(credentialModel.getUserName())
                .firstName(credentialModel.getFirstName())
                .lastName(credentialModel.getLastName())
                .email(credentialModel.getEmail())
                .build();
        userService.saveUser(userModel);
    }
}
