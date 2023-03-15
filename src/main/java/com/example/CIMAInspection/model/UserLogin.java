package com.example.CIMAInspection.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
    private String usernameOrEmail;
    private String password;
}
