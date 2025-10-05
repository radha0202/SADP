package com.login_system.assi3.controller;

import com.login_system.assi3.dto.UserRegistrationDto;
import com.login_system.assi3.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    private final UserService userService;

    public AuthRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> apiRegister(@Valid @RequestBody UserRegistrationDto dto) {
        try {
            String token = userService.register(dto);
            String link = "/api/auth/verify?token=" + token;
            return ResponseEntity.status(201).body(
                    new java.util.HashMap<String, String>() {{
                        put("message", "Registered. Verify at " + link);
                        put("verifyLink", link);
                    }}
            );
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", ex.getMessage()));
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<?> apiVerify(@RequestParam String token) {
        boolean ok = userService.verify(token);
        if (ok) return ResponseEntity.ok(java.util.Map.of("message", "Verified"));
        return ResponseEntity.badRequest().body(java.util.Map.of("error", "Invalid token"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> apiLogin(@RequestBody java.util.Map<String,String> body) {
        String email = body.get("email");
        String password = body.get("password");
        var user = userService.login(email, password);
        if (user == null) {
            return ResponseEntity.status(401).body(java.util.Map.of("error", "Invalid credentials or account not verified"));
        }
        return ResponseEntity.ok(java.util.Map.of("message", "Login successful", "username", user.getUsername() == null ? user.getEmail() : user.getUsername()));
    }
}
