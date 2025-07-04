package com.example.lion.auth.service;

import com.example.lion.professor.ProfessorEntity;
import com.example.lion.professor.ProfessorRepository;
import com.example.lion.student.StudentEntity;
import com.example.lion.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public void registerStudent(String name, String email, String department, String number, String password) {
        StudentEntity student = StudentEntity.builder()
                .studentName(name)
                .studentEmail(email)
                .studentDepartment(department)
                .studentNumber(number)
                .studentPassword(password)
                .build();

        studentRepository.save(student);
    }

    public void registerProfessor(String name, String email, String department, String number, String password) {
        ProfessorEntity professor = ProfessorEntity.builder()
                .name(name)
                .email(email)
                .department(department)
                .number(number)
                .password(password)
                .build();

        professorRepository.save(professor);
    }

    public boolean loginStudent(String email, String password) {
        Optional<StudentEntity> studentOpt = studentRepository.findByStudentEmail(email);
        return studentOpt.map(student -> student.getStudentPassword().equals(password)).orElse(false);
    }

    public boolean loginProfessor(String email, String password) {
        Optional<ProfessorEntity> professorOpt = professorRepository.findByEmail(email);
        return professorOpt.map(prof -> prof.getPassword().equals(password)).orElse(false);
    }
}
