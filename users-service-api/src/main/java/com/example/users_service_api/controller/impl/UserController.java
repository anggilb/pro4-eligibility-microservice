package com.example.users_service_api.controller.impl;

import com.example.users_service_api.commons.dtos.UserRequest;
import com.example.users_service_api.controller.UserApi;
import com.example.users_service_api.service.impl.UserDetailsImpl;
import com.example.users_service_api.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    private final UserDetailsImpl userDetails;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserDetailsImpl userDetails, UserServiceImpl userServiceImpl) {
        this.userDetails = userDetails;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public ResponseEntity<UserDetails> getUser(Long userId) {
        return ResponseEntity.ok(userDetails.loadUserById(userId));
    }

    @Override
    public ResponseEntity<Void> putUser(Long userId, UserRequest userRequest) {
        userServiceImpl.putUser(userId, userRequest);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userServiceImpl.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}