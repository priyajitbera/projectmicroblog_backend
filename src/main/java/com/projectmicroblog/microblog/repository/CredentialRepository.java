package com.projectmicroblog.microblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

    Optional<Credential> findByUserName(String username);

    Optional<Credential> findByEmail(String email);
}
