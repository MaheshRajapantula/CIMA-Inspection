package com.example.CIMAInspection.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String employeeId;
}
