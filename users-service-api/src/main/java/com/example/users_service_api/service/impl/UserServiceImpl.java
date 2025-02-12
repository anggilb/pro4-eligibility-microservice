package com.example.users_service_api.service.impl;

import com.example.users_service_api.commons.dtos.UserRequest;
import com.example.users_service_api.commons.entities.UserModel;
import com.example.users_service_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void putUser(Long userId, UserRequest userRequest) {
        userRepository.findById(userId)
                .map(existingUser -> updatedFieldsUser(existingUser, userRequest))
                .map(userRepository::save)
                .orElseThrow(() -> new RuntimeException("Error couldn't edit user by id"));
    }

    private UserModel updatedFieldsUser(UserModel existingUser, UserRequest userRequest) {
        existingUser.setName(userRequest.getName());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setPassword(userRequest.getPassword());
        return existingUser;
    }

    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(
                        userRepository::delete,
                        () -> {
                            throw new RuntimeException("User with ID " + userId + " not found");
                        }
                );
    }
}
