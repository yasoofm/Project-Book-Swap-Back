package com.BookSwap.App.services.auth;

import com.BookSwap.App.authentication.CustomUserDetails;
import com.BookSwap.App.authentication.CustomUserDetailsService;
import com.BookSwap.App.authentication.JWTUtil;
import com.BookSwap.App.bo.auth.AuthenticationResponse;
import com.BookSwap.App.bo.auth.LoginRequest;
import com.BookSwap.App.bo.auth.SignupRequest;
import com.BookSwap.App.entities.RoleEntity;
import com.BookSwap.App.repositories.RoleRepository;
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
    private final RoleRepository roleRepository;

    public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JWTUtil jwtUtil, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }
    @Override
    public void signup(SignupRequest signupRequest) {
        RoleEntity role = roleRepository.findRoleEntityByTitle(Role.user.name()).orElseThrow();
        UserEntity user = new UserEntity();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail().toLowerCase());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setRole(role);
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

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String accessToken = jwtUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setEmail(userDetails.getUsername());
        response.setId(userDetails.getId());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer " + accessToken);

        return response;
    }
}
