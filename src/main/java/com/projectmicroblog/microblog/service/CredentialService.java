package com.projectmicroblog.microblog.service;

import java.util.Optional;

import com.projectmicroblog.microblog.entity.Credential;
import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.CredentialModel;

public interface CredentialService {

    public User saveCredential(CredentialModel credentialModel);

    public void updateCredential(CredentialModel credentialModel);

    public Optional<Credential> findCredentialByHandleOrEmail(String username, String email);
}
