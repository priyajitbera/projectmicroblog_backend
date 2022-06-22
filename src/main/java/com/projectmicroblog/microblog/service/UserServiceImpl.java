package com.projectmicroblog.microblog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.UserModel;
import com.projectmicroblog.microblog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserModel userModel){
        String userId = userModel.getUserName();
        if(!isUserNameAvailable(userId)) return null; //TODO: raise exception
        User user = User.builder()
                    .userName(userModel.getUserName())
                    .firstName(userModel.getFirstName())
                    .lastName(userModel.getLastName())
                    .email(userModel.getEmail())
                    .build();
        return userRepository.save(user);
    }

    public User findById(Long userId){
        return userRepository.findById(userId).get(); //TODO: raise exception
    }
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName).get(); //TODO: raise exception
    }
    public boolean isUserNameAvailable(String userName){
        return !userRepository.findByUserName(userName).isPresent();
    }
}
