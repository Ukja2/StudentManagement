package com.example.lion.professor;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String name;
    private String password;
    private String number;
    private String email;
    private String department;
}
