package com.example.auth_service_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.auth_service_api", "com.example.users_service_api"})
public class AuthServiceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApiApplication.class, args);
    }
}