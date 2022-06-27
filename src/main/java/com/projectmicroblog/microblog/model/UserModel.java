package com.projectmicroblog.microblog.model;

import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    public static void validateUserName(String userName) {
        if (userName == null || userName.equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateFirstName(String firstName) {
        if (firstName == null || firstName.equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateLastName(String lastName) {
        if (lastName == null || lastName.equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        if (!Pattern.compile(regex).matcher(email).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
