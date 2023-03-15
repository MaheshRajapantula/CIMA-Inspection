package com.example.CIMAInspection.service.impl;

import com.example.CIMAInspection.entity.User;
import com.example.CIMAInspection.model.UserSignUp;
import com.example.CIMAInspection.repository.UserRepository;
import com.example.CIMAInspection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<Object> isUserPresent(UserSignUp user) {
        boolean userExists = false;
        String message = null;
        Optional<User> existingUserEmail = userRepository.findByEmail(user.getEmail());
        if(existingUserEmail.isPresent()){
            userExists = true;
            message = "Email Already Present!";
        }
        Optional<User> existingUserEmployeeId = userRepository.findByEmployeeId(user.getEmployeeId());
        if(existingUserEmployeeId.isPresent()){
            userExists = true;
            message = "Employee Id Already Present!";
        }
        if (existingUserEmail.isPresent() && existingUserEmployeeId.isPresent()) {
            message = "Email and Employee Id Both Already Present!";
        }
        System.out.println("existingUserEmail.isPresent() - "+existingUserEmail.isPresent()+"existingUserEmployeeId.isPresent() - "+existingUserEmployeeId.isPresent());
        return Arrays.asList(userExists, message);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", email)
                ));
    }

    @Override
    public Boolean isUserExists(int userId) {
        return userRepository.existsById((long) userId);
    }
}
