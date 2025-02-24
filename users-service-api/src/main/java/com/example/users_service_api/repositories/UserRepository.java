package com.example.users_service_api.repositories;

import com.example.users_service_api.commons.entities.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

    boolean existsByEmail(@NotNull @NotEmpty @Email String email);
}
