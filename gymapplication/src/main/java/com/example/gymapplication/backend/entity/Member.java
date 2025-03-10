package com.example.gymapplication.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table(name = "members")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
    private String phone;
}

