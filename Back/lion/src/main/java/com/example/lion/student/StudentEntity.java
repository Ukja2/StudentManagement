package com.example.lion.student;

import com.example.lion.enrollment.EnrollmentEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false, unique = true)
    private String studentEmail;

    @Column(nullable = false)
    private String studentPassword;

    @Column(nullable = false)
    private String studentDepartment;

//    @OneToMany(mappedBy = "student_id", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<EnrollmentEntity> enrollment;

    public StudentDTO toDTO() {
        return StudentDTO.builder()
                .studentId(studentId)
                .studentName(studentName)
                .studentEmail(studentEmail)
                .studentDepartment(studentDepartment)
                .build();
    }
}
