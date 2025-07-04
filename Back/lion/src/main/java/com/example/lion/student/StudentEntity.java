package com.example.lion.student;

import com.example.lion.enrollment.EnrollermentEntity;
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
    private java.lang.Long studentId;

    @Column
    private String studentName;

    @Column
    private String studentNumber;

    @Column
    private String studentEmail;

    @Column
    private java.lang.Long studentYear;

    @OneToMany(mappedBy = "student_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollermentEntity> enrollment;



    public StudentDTO toDTO() {
        return StudentDTO.builder()
                .studentId(studentId)
                .studentName(studentName)
                .studentNumber(studentNumber)
                .studentEmail(studentEmail)
                .studentYear(studentYear)
                .build();
    }
}
