package com.example.lion.grade;

import com.example.lion.enrollment.EnrollmentEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grade")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradeId;

    @Column
    private String gradeValue;

    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private EnrollmentEntity enrollment;


    public GradeDTO toDTO() {
        return GradeDTO.builder()
                .gradeId(gradeId)
                .gradeValue(gradeValue)
                .enrollment(enrollment.getEnrollmentId())
                .build();
    }
}
