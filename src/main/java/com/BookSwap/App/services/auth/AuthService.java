package com.BookSwap.App.services.auth;

import com.BookSwap.App.bo.auth.AuthenticationResponse;
import com.BookSwap.App.bo.auth.LoginRequest;
import com.BookSwap.App.bo.auth.SignupRequest;

public interface AuthService {
    void signup(SignupRequest signupRequest);

    AuthenticationResponse login(LoginRequest loginRequest);
}
