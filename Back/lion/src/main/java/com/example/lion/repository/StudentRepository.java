package com.example.lion.repository;

import com.example.lion.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // userId 기반으로 찾는 경우 (PK = FK)
    Optional<Student> findByStudentId(Long studentId);

    // 학번(studentNumber)으로 찾고 싶으면
    Optional<Student> findByStudentNumber(String studentNumber);
}
