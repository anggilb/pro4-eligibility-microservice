package com.example.users_service_api.controller;

import com.example.users_service_api.commons.constants.ApiPathConstants;
import com.example.users_service_api.commons.dtos.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.USER_ROUTE)
public interface UserApi {
        @GetMapping(value = "/get")
        ResponseEntity<?> getUser(
                        @RequestHeader("X-User-Id") Long userId);

        @PutMapping(value = "/put")
        ResponseEntity<?> putUser(
                        @RequestHeader("X-User-Id") Long userId,
                        @RequestBody @Valid UserRequest userRequest,
                        BindingResult result);

        @DeleteMapping(value = "/delete")
        ResponseEntity<?> deleteUser(
                        @RequestHeader("X-User-Id") Long userId);
}