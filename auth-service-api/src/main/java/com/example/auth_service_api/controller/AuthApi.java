package com.example.auth_service_api.controller;

import com.example.auth_service_api.commons.constants.ApiPathConstants;
import com.example.users_service_api.commons.dtos.UserRequest;
import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.auth_service_api.commons.dtos.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {
    @PostMapping(value = "/register")
    ResponseEntity<TokenResponse> createUser(
            @RequestBody @Valid UserRequest userRequest
    );

    @PostMapping(value = "/login")
    ResponseEntity<TokenResponse> loginUser(
            @RequestBody @Valid LoginRequest loginRequest
    );
}
