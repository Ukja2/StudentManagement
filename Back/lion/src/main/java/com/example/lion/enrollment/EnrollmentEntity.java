package com.example.lion.enrollment;

import com.example.lion.course.CourseEntity;
import com.example.lion.student.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enrollerment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
}
