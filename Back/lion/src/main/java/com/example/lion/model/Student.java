package com.example.lion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    private Long studentId; // User.userId 와 동일

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private User user;

    private String studentNumber;
}
