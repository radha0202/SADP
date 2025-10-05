package com.login_system.assi3.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRegistrationDto {

    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$",
             message = "Email must contain @ and end with .com")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$",
             message = "Password must be 8+ chars with 1 uppercase, 1 number & 1 symbol")
    private String password;

    // getters & setters
    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }
}
