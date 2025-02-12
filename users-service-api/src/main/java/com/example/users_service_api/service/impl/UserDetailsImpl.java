package com.example.users_service_api.service.impl;

import com.example.users_service_api.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("UserDetailsService user not found"));
    }

    public UserDetails loadUserById(Long userId) throws UsernameNotFoundException {
        return Optional.of(userId)
                .flatMap(userRepository::findById)
                .orElseThrow(() -> new RuntimeException("Error couldn't find user by id"));
    }
}
