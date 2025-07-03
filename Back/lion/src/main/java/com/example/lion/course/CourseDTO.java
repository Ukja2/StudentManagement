package com.example.lion.course;

import com.example.lion.professor.ProfessorEntity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long courseId;
    private Long courseCode;
    private String courseName;
    private ProfessorEntity professor;
}
