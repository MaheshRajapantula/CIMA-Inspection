package com.example.CIMAInspection.controller;

import com.example.CIMAInspection.entity.User;
import com.example.CIMAInspection.model.UserLogin;
import com.example.CIMAInspection.model.UserLoginResponse;
import com.example.CIMAInspection.model.UserSignUp;
import com.example.CIMAInspection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<?> authenticateUser(@RequestBody UserLogin userLogin) {
        User user;
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setMessage("Invalid User/Password!.");
        try {
            user = userService.loadUserByUsername(userLogin.getUsernameOrEmail());
        } catch (UsernameNotFoundException ex) {
            return new ResponseEntity<>(userLoginResponse, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
        if (passwordEncoder.matches(userLogin.getPassword(), user.getPassword())) {
            userLoginResponse.setMessage("User signed-in successfully!.");
            userLoginResponse.setUserId(user.getId());
            return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userLoginResponse, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<?> registerUser(@RequestBody UserSignUp userSignUp){
        System.out.println("here");
        List<Object> userExists = userService.isUserPresent(userSignUp);

        // add check for email exists in DB
        if((Boolean) userExists.get(0)){
            return new ResponseEntity<>(userExists.get(1), HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setFirstName(userSignUp.getFirstName());
        user.setLastName(userSignUp.getLastName());
        user.setEmail(userSignUp.getEmail());
        user.setEmployeeId(userSignUp.getEmployeeId());
        String encodedPassword = passwordEncoder.encode(userSignUp.getPassword());
        user.setPassword(encodedPassword);

        userService.saveUser(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
