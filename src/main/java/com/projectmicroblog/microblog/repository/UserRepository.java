package com.projectmicroblog.microblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmicroblog.microblog.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
