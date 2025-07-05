package com.example.lion.student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    Optional<StudentEntity> findByStudentEmail(String email);
}
