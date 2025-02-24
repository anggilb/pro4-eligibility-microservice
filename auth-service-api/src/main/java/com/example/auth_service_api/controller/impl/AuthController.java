package com.example.auth_service_api.controller.impl;

import com.example.auth_service_api.commons.dtos.LoginRequest;
import com.example.auth_service_api.commons.dtos.TokenResponse;
import com.example.users_service_api.commons.dtos.UserRequest;
import com.example.auth_service_api.controller.AuthApi;
import com.example.auth_service_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public ResponseEntity<?> createUser(@Valid UserRequest userRequest, BindingResult result) {
        try {
            if (result.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );
                return ResponseEntity.badRequest().body(errors);
            }

            return ResponseEntity.ok(authService.createUser(userRequest));

        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Ocurrió un error interno en el servidor");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    @Override
    public ResponseEntity<?> loginUser(@Valid LoginRequest loginRequest, BindingResult result) {
        try {
            if (result.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );
                return ResponseEntity.badRequest().body(errors);
            }

            return ResponseEntity.ok(authService.loginUser(loginRequest));

        } catch (RuntimeException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);

        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Ocurrió un error interno en el servidor");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}
