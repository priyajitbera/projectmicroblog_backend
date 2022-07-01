package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.CredentialModel;

public interface AuthService {

    public User registerUser(CredentialModel credentialModel);

    public String generateToken(String username, String password);

    public void updatePassword(CredentialModel credentialModel);
}
