package com.example.lion.student;

import com.example.lion.enrollment.EnrollmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column
    private String studentName;

    @Column
    private String studentNumber;

    @Column
    private String studentEmail;

    @Column
    private String studentPassword;

    @Column
    private String studentDepartment;


    @OneToMany(mappedBy = "student_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentEntity> enrollment;



    public StudentDTO toDTO() {
        return StudentDTO.builder()
                .studentId(studentId)
                .studentName(studentName)
                .studentNumber(studentNumber)
                .studentEmail(studentEmail)
                .studentPassword(studentPassword)
                .studentDepartment(studentDepartment)
                .build();
    }
}
