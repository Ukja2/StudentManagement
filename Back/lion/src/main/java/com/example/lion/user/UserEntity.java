package com.example.lion.user;

import com.example.lion.course.CourseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    public enum UserRole {
        STUDENT,
        PROFESSOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .userId(userId)
                .userName(userName)
                .password(password)
                .email(email)
                .department(department)
                .role(role)
                .build();
    }
}
