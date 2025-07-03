package com.example.lion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grade {

    @Id
    @GeneratedValue
    private Long gradeId;

    private String gradeValue;

    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;
}
