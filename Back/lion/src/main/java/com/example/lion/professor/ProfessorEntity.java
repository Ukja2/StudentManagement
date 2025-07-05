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
    private Long professorId;

    @Column(nullable = false)
    private String professorName;

    @Column(nullable = false)
    private String professorPassword;

    @Column(nullable = false, unique = true)
    private String professorEmail;

    @Column(nullable = false)
    private String professorDepartment;

    public ProfessorDTO toDTO() {
        return ProfessorDTO.builder()
                .professorId(professorId)
                .professorName(professorName)
                .professorEmail(professorEmail)
                .professorDepartment(professorDepartment)
                .build();
    }
}
