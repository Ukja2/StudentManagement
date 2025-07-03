package com.example.lion.professor;

import com.example.lion.student.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "professorId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentEntity> students;

    public ProfessorDTO toDTO() {
        return ProfessorDTO.builder()
                .professorId(professorId)
                .professorName(professorName)
                .professorPassword(professorPassword)
                .professorEmail(professorEmail)
                .professorDepartment(professorDepartment)
                .build();
    }
}
