package com.projectmicroblog.microblog.service;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.UserModel;

public interface UserService {

    public User saveUser(UserModel userModel);

    public boolean isUserNameAvailable(String userName);

    public User findUserById(Long userId);

    public User findByUserName(String userName);

    public boolean isEmailAvailable(String email);
}
