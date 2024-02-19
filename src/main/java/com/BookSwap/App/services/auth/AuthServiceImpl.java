package com.BookSwap.App.services.auth;

import com.BookSwap.App.authentication.CustomUserDetailsService;
import com.BookSwap.App.authentication.JWTUtil;
import com.BookSwap.App.bo.auth.AuthenticationResponse;
import com.BookSwap.App.bo.auth.LoginRequest;
import com.BookSwap.App.bo.auth.SignupRequest;
import com.BookSwap.App.utils.enums.Role;
import com.BookSwap.App.entities.UserEntity;
import com.BookSwap.App.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JWTUtil jwtUtil, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public void signup(SignupRequest signupRequest) {
        UserEntity user = new UserEntity();
        user.setName(signupRequest.getName());
        user.setUsername(signupRequest.getEmail().toLowerCase());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    private void authentication(String username, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        if(loginRequest.getEmail().isEmpty())
            throw new NullPointerException("email is empty");
        if(loginRequest.getPassword().isEmpty())
            throw new NullPointerException("password is empty");
        String username = loginRequest.getEmail().toLowerCase();
        String password = loginRequest.getPassword();

        authentication(username, password);

        UserEntity user = userDetailsService.loadUserByUsername(username);
        String accessToken = jwtUtil.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setEmail(user.getUsername());
        response.setId(user.getId());
        response.setRole(user.getRole().name());
        response.setToken("Bearer " + accessToken);

        return response;
    }
}
