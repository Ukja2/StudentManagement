package com.example.lion.Student;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity addStudent(String studentName, String studentNumber, String studentEmail) {
        return studentRepository.save(StudentEntity.builder()
                .studentName(studentName)
                .studentNumber(studentNumber)
                .studentEmail(studentEmail)
                .build());
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudent(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public StudentDTO getProfile(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생 존재X"));
        return student.toDTO();
    }


}
