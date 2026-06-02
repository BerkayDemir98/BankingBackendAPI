package org.example.bankingbackendapi.service;

import org.example.bankingbackendapi.dto.AuthResponse;
import org.example.bankingbackendapi.dto.LoginRequest;
import org.example.bankingbackendapi.dto.RegisterRequest;
import org.example.bankingbackendapi.repository.UserRepository;
import org.example.bankingbackendapi.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User(
                registerRequest.username(),
                registerRequest.email(),
                passwordEncoder.encode(registerRequest.password()),
                "USER"
        );


        User savedUser = userRepository.save(user);

        return new AuthResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    public AuthResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new RuntimeException("Invalid email or password"));

        boolean passwordMatches = passwordEncoder.matches(loginRequest.password(), user.getPassword());

        if (!passwordMatches) {
            throw new RuntimeException("Invalid email or password");
        }

        return new AuthResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
    }
}
