package com.example.gymapplication.backend.controller;

import com.example.gymapplication.backend.entity.User;
import com.example.gymapplication.backend.repository.UserRepository;
import com.example.gymapplication.backend.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    /*@PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> dbUser = userRepository.findByUsername(user.getUsername());
        System.out.println("Checking for user: " + dbUser);
        if (dbUser.isPresent() && passwordEncoder.matches(user.getPassword(), dbUser.get().getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        return "Invalid credentials";
    }*/
}

