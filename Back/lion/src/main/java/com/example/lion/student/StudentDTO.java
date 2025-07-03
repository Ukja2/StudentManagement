package com.example.lion.student;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String studentNumber;
    private String studentEmail;
    private String studentPassword;
    private String studentDepartment;
}
