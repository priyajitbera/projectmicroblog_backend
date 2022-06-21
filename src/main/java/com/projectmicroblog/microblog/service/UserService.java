package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.UserModel;

public interface UserService {
    
    public User saveUser(UserModel userModel);
    public boolean isUserIdAvailable(String userName);
    public User findById(Long userId);
}
