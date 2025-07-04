package com.example.lion.grade;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    private Long gradeId;
    private String gradeValue;
    private Long enrollment;
}
