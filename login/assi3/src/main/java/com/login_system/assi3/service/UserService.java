package com.login_system.assi3.service;

import com.login_system.assi3.dto.UserRegistrationDto;
import com.login_system.assi3.model.User;
import com.login_system.assi3.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Register user and return verification token (for demo we return the token so it can be clicked)
     */
    public String register(UserRegistrationDto dto) {
        // prevent duplicate email
        Optional<User> existing = userRepository.findByEmail(dto.getEmail());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        User u = new User();
        u.setUsername(dto.getUsername());
        u.setEmail(dto.getEmail());
        u.setPassword(passwordEncoder.encode(dto.getPassword()));
        u.setVerified(false);
        u.setVerificationToken(UUID.randomUUID().toString());

        userRepository.save(u);
        return u.getVerificationToken();
    }

    /**
     * Verify token
     */
    public boolean verify(String token) {
        Optional<User> opt = userRepository.findByVerificationToken(token);
        if (opt.isPresent()) {
            User u = opt.get();
            u.setVerified(true);
            u.setVerificationToken(null);
            userRepository.save(u);
            return true;
        }
        return false;
    }

    /**
     * Login - returns user if success and verified, else null
     */
    public User login(String email, String rawPassword) {
        Optional<User> opt = userRepository.findByEmail(email);
        if (opt.isEmpty()) return null;
        User u = opt.get();
        if (!passwordEncoder.matches(rawPassword, u.getPassword())) return null;
        return u.isVerified() ? u : null; // returns null if not verified
    }
}
