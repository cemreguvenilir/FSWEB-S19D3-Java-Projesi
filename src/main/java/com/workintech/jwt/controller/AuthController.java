package com.workintech.jwt.controller;

import com.workintech.jwt.dto.LoginRequest;
import com.workintech.jwt.dto.LoginResponse;
import com.workintech.jwt.dto.RegistrationMember;
import com.workintech.jwt.entity.Member;
import com.workintech.jwt.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember){
        return authenticationService.register(registrationMember.getEmail(), registrationMember.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
