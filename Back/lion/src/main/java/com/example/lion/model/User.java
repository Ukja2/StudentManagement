package com.example.lion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    private String userName;
    private String password;
    private String email;
    private String department;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        STUDENT,
        PROFESSOR
    }
}
