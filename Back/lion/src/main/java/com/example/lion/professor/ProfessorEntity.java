package com.example.lion.professor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "professor")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    public ProfessorDTO toDTO() {
        return ProfessorDTO.builder()
                .id(id)
                .name(name)
                .password(password)
                .email(email)
                .department(department)
                .build();
    }
}
