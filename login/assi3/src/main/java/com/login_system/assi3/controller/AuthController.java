package com.login_system.assi3.controller;

import com.login_system.assi3.dto.UserRegistrationDto;
import com.login_system.assi3.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid @ModelAttribute("user") UserRegistrationDto userDto,
                             BindingResult binder,
                             Model model) {
        if (binder.hasErrors()) {
            return "register";
        }
        try {
            String token = userService.register(userDto);
            String verifyLink = "/verify?token=" + token;
            model.addAttribute("success", "Registered successfully. Click to verify: " + verifyLink);
            return "login";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
    }

    @GetMapping("/verify")
    public String verify(@RequestParam("token") String token, Model model) {
        boolean ok = userService.verify(token);
        if (ok) {
            model.addAttribute("success", "Account verified successfully. Please login.");
            return "login";
        } else {
            model.addAttribute("error", "Invalid or expired token");
            return "login";
        }
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email,
                          @RequestParam String password,
                          Model model) {
        var user = userService.login(email, password);
        if (user == null) {
            // check if email exists but not verified -> show proper message
            model.addAttribute("error", "Invalid credentials or account not verified.");
            return "login";
        }
        model.addAttribute("username", user.getUsername() != null ? user.getUsername() : user.getEmail());
        model.addAttribute("success", "Login successful!");
        return "home";
    }
}
