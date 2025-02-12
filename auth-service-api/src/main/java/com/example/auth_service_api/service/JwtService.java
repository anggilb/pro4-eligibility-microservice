package com.example.auth_service_api.service;

import com.example.auth_service_api.commons.dtos.TokenResponse;

public interface JwtService {
    TokenResponse generateToken(Long userId);
}
