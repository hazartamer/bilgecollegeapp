package com.example.bilgecollegeapp.controller;

import com.example.bilgecollegeapp.service.concretes.AuthServiceImpl;
import com.example.bilgecollegeapp.model.dtos.auth.LoginRequest;
import com.example.bilgecollegeapp.model.dtos.auth.RegisterRequest;
import com.example.bilgecollegeapp.model.dtos.auth.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auths")
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;
    @PostMapping("login")
    public String login(LoginRequest request){
        return authService.login(request);
    }
    @PostMapping
    public RegisterResponse register(RegisterRequest request){
        return authService.register(request);
    }

}
