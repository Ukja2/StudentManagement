package com.example.lion.professor;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long professorId;
    private String professorName;
    private String professorPassword;
    private String professorEmail;
    private String professorDepartment;
}
