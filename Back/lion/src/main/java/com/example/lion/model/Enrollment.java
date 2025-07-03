package com.example.lion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Enrollment {

    @Id
    @GeneratedValue
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private Grade grade;
}
