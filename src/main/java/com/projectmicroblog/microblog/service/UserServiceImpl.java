package com.projectmicroblog.microblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projectmicroblog.microblog.entity.User;
import com.projectmicroblog.microblog.model.UserModel;
import com.projectmicroblog.microblog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserModel userModel) {
        // data validity check
        UserModel.validateFirstName(userModel.getFirstName());
        UserModel.validateLastName(userModel.getLastName());
        UserModel.validateEmail(userModel.getEmail());
        UserModel.validateUserName(userModel.getUserName());
        // userName availabilty check
        if (!isUserNameAvailable(userModel.getUserName())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Requested userName=" + userModel.getUserName() + " is unavailable");
        }

        User user = User.builder()
                .userName(userModel.getUserName())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .email(userModel.getEmail())
                .build();
        return userRepository.save(user);
    }

    public User findById(Long userId) {
        try {
            return userRepository.findById(userId).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No User found with userId=" + userId);
        }
    }

    public User findByUserName(String userName) {
        // data validity check
        UserModel.validateUserName(userName);
        try {
            return userRepository.findByUserName(userName).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No User found with userName=" + userName);
        }
    }

    public boolean isUserNameAvailable(String userName) {
        // data validty check
        UserModel.validateUserName(userName);
        return !userRepository.findByUserName(userName).isPresent();
    }
}
