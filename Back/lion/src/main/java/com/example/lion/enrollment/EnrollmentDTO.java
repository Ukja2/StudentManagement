package com.example.lion.enrollment;

import com.example.lion.course.CourseEntity;
import com.example.lion.student.StudentDTO;
import com.example.lion.student.StudentEntity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {
    private Long enrollmentId;
    private Long studentId;
    private Long courseId;
    private EnrollermentEntity enrollmentId;
}
