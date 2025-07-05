package com.example.lion.course;

import com.example.lion.enrollment.EnrollmentEntity;
import com.example.lion.professor.ProfessorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long courseId;

    @Column(nullable = false, unique = true)
    private java.lang.Long courseCode;

    @Column(nullable = false, unique = true)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "professorId")
    private ProfessorEntity professor;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentEntity> enrollment;

    public CourseDTO toDTO() {
        return CourseDTO.builder()
                .courseId(courseId)
                .courseCode(courseCode)
                .courseName(courseName)
                .professor(professor)
                .build();
    }
}
