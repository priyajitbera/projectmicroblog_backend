package com.projectmicroblog.microblog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projectmicroblog.microblog.entity.Credential;
import com.projectmicroblog.microblog.entity.User;
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

    @Override
    public User saveCredential(CredentialModel credentialModel) {
        // create and save a new credential
        Credential credential = Credential.builder()
                .handle(credentialModel.getHandle())
                .email(credentialModel.getEmail())
                .password(passwordEncoder.encode(credentialModel.getPassword()))
                .build();
        try {
            credential = credentialRepository.save(credential);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // create userModel using details of credentialModel and save a new User
        UserModel userModel = UserModel.builder()
                .handle(credentialModel.getHandle())
                .firstName(credentialModel.getFirstName())
                .lastName(credentialModel.getLastName())
                .email(credentialModel.getEmail())
                .build();
        try {
            return userService.saveUser(userModel);
        } catch (Exception ex) { // if any error in saving user, deletes the saved credential
            credentialRepository.delete(credential);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Optional<Credential> findCredentialByHandleOrEmail(String username, String email) {
        return credentialRepository.findByHandleOrEmail(username, email);
    }

    @Override
    public void updateCredential(CredentialModel credentialModel) {
        Credential credential = credentialRepository
                .findByHandleOrEmail(
                        credentialModel.getHandle(),
                        credentialModel.getEmail())
                .get();
        credential.setPassword(credentialModel.getNewPassword());
        try {
            credentialRepository.save(credential);
        } catch (Exception ex) {
            credentialRepository.delete(credential);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
