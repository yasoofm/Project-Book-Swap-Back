package com.BookSwap.App.services.auth;

import com.BookSwap.App.bo.customeUserDetails.CustomUserDetails;
import com.BookSwap.App.entities.UserEntity;
import com.BookSwap.App.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private CustomUserDetails buildCustomUserDetailsOfUsername(String username) throws NotFoundException {
        UserEntity user = userRepository.findByEmail(username).orElseThrow();
        if(user == null){
            throw new NotFoundException("User not found");
        }
        CustomUserDetails userDetails = new CustomUserDetails();
        userDetails.setUsername(user.getEmail());
        userDetails.setId(user.getId());
        userDetails.setName(user.getName());
        userDetails.setPassword(user.getPassword());
        userDetails.setRole(user.getRole().getTitle().toString());
        userDetails.setPhoneNumber(user.getPhoneNumber());
        return userDetails;
    }
    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return buildCustomUserDetailsOfUsername(s);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
