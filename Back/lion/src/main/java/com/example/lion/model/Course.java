package com.example.lion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private Long courseId;

    private String courseCode;
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
