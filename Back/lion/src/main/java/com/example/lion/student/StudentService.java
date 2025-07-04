package com.example.lion.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentEntity addStudent(String studentName, String studentPassword, String studentEmail, String department) {
        return studentRepository.save(StudentEntity.builder()
                .studentName(studentName)
                .studentEmail(studentEmail)
                .studentPassword(studentPassword)
                .department(department)
                .build());
    }

    public StudentEntity getStudent(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new RuntimeException("Student not found"));
    }
}
