package com.api.innovation.application.auth.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.innovation.infra.databases.hibernate.users.models.User;
import com.api.innovation.infra.databases.hibernate.users.repositories.UserRepository;

@Service
public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if (!user.isPresent()) {
            return null;
        }

        return user;
    }
}
