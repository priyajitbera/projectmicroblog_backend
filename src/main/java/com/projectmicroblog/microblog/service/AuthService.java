package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.model.CredentialModel;

public interface AuthService {

    public String registerUser(CredentialModel credentialModel);

    public String generateToken(String username, String password);
}
