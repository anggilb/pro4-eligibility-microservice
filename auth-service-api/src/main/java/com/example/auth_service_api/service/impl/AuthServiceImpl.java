package com.example.auth_service_api.service.impl;

import com.example.auth_service_api.service.AuthService;
import com.example.auth_service_api.commons.dtos.LoginRequest;
import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.users_service_api.commons.dtos.UserRequest;
import com.example.users_service_api.commons.entities.UserModel;
import com.example.users_service_api.repositories.UserRepository;
import com.example.auth_service_api.service.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .role("USER")
                .build();
    }

    @Override
    public TokenResponse loginUser(LoginRequest loginRequest) {
        return Optional.of(loginRequest.getEmail())
                .flatMap(userRepository::findByEmail)
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
                .map(userDetails -> jwtService.generateToken(userDetails.getUserId()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials."));
    }
}
