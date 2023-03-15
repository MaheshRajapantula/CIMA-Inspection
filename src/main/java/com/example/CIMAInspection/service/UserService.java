package com.example.CIMAInspection.service;

import com.example.CIMAInspection.entity.User;
import com.example.CIMAInspection.model.UserSignUp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<Object> isUserPresent(UserSignUp user);

    void saveUser(User user);

    User loadUserByUsername(String email);

    Boolean isUserExists(int userId);
}
