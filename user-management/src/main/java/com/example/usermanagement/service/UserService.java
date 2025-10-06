package com.example.usermanagement.service;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    public List<User> getAllUsers() { return repo.findAll(); }
    public Optional<User> getUserById(Long id) { return repo.findById(id); }
    public User registerUser(User user) { return repo.save(user); }
    public User updateUser(Long id, User userDetails) {
        return repo.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return repo.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
    public void deleteUser(Long id) { repo.deleteById(id); }
    public boolean login(String email, String password) {
        return repo.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
