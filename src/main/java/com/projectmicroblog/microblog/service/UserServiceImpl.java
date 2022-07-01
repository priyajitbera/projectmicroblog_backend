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
        // email availabilty check
        if (!isEmailAvailable(userModel.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "email=" + userModel.getEmail() + " is unavailable");
        }
        // handle availabilty check
        if (!isHandleAvailable(userModel.getHandle())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "userName=" + userModel.getHandle() + " is unavailable");
        }

        User user = User.builder()
                .handle(userModel.getHandle())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .email(userModel.getEmail())
                .build();
        try { // handles bad data
            return userRepository.save(user);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public User findUserById(Long userId) {
        try {
            return userRepository.findById(userId).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No User found with userId=" + userId);
        }
    }

    public User findUserByHandle(String handle) {
        try {
            return userRepository.findByHandle(handle).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No User found with handle=" + handle);
        }
    }

    public boolean isHandleAvailable(String handle) {
        return !userRepository.findByHandle(handle).isPresent();
    }

    public boolean isEmailAvailable(String email) {
        System.out.println("in isEmailAvail()");
        return !userRepository.findByEmail(email).isPresent();
    }
}
