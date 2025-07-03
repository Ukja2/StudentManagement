package com.example.lion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Professor {

    @Id
    private Long professorId; // User.userId와 동일

    @OneToOne
    @MapsId
    @JoinColumn(name = "professor_id")
    private User user;

    private String professorNumber; // 교수 전용 식별자 (예: 사번)
}
