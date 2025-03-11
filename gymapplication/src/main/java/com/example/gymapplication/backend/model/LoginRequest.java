package com.example.gymapplication.backend.model;

public class LoginRequest {
    private String username;  // Change from 'name' to 'username'
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;  // Ensure you're using 'username' here
    }

    public void setUsername(String username) {
        this.username = username;  // Set 'username' correctly
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
