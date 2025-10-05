package com.login_system.assi3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // username is optional display name
    private String username;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$",
             message = "Email must contain @ and end with .com")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$",
             message = "Password must be 8+ chars with 1 uppercase, 1 number & 1 symbol")
    private String password; // will store BCrypt hash

    private boolean verified = false;

    @Column(name = "verification_token")
    private String verificationToken;

    public User() {}

    // getters & setters (omitted here for brevity; include them in file)
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }

    public boolean isVerified(){ return verified; }
    public void setVerified(boolean verified){ this.verified = verified; }

    public String getVerificationToken(){ return verificationToken; }
    public void setVerificationToken(String verificationToken){ this.verificationToken = verificationToken; }
}
