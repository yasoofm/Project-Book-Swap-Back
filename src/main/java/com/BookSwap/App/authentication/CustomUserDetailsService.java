package com.BookSwap.App.authentication;

import com.BookSwap.App.entities.User_Entity;
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

    private User_Entity buildCustomUserDetailsOfUsername(String username) throws NotFoundException {
        User_Entity user = userRepository.findByUsername(username).orElseThrow();
        if(user == null){
            throw new NotFoundException("User not found");
        }
        return user;
    }
    @Override
    public User_Entity loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            return buildCustomUserDetailsOfUsername(s);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
