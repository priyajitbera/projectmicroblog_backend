package com.projectmicroblog.microblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialModel {

    private String handle;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String newPassword; // used in updating password
}
