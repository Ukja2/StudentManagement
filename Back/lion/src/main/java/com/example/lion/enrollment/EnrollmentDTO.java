package com.example.lion.enrollment;

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
}
