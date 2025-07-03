package com.example.lion.professor;

import com.example.lion.course.CourseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professor")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professorId;

    @OneToMany(mappedBy = "professorId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseEntity> courses;

}
