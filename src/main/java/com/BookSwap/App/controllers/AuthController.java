package com.BookSwap.App.controllers;

import com.BookSwap.App.bo.auth.AuthenticationResponse;
import com.BookSwap.App.bo.auth.LoginRequest;
import com.BookSwap.App.bo.auth.SignupRequest;
import com.BookSwap.App.services.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest){
        authService.signup(signupRequest);
        return ResponseEntity.ok("User created successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest){
        AuthenticationResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
