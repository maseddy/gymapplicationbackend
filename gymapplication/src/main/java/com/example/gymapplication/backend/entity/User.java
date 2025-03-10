package com.example.gymapplication.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role; // ROLE_ADMIN, ROLE_USER
}

