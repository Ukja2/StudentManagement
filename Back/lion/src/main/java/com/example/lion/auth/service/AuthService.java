package com.example.lion.auth.service;

import com.example.lion.professor.ProfessorEntity;
import com.example.lion.student.StudentEntity;
import com.example.lion.student.StudentRepository;
import com.example.lion.professor.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public void registerStudent(String name, String password, String email, String department) {
        StudentEntity student = new StudentEntity();
        student.setStudentName(name);
        student.setStudentPassword(password);
        student.setStudentEmail(email);
        student.setStudentDepartment(department);
        studentRepository.save(student);
    }

    public void registerProfessor(String name, String password, String email, String department) {
        ProfessorEntity professor = new ProfessorEntity();
        professor.setProfessorName(name);
        professor.setProfessorPassword(password);
        professor.setProfessorEmail(email);
        professor.setProfessorDepartment(department);
        professorRepository.save(professor);
    }

    public boolean existsStudent(String email) {
        return studentRepository.existsById(email);
    }

    public boolean loginStudent(String email, String password) {
        return studentRepository.findByStudentEmail(email)
                .map(student -> student.getStudentPassword().equals(password))
                .orElse(false);
    }

    public boolean loginProfessor(String email, String password) {
        return professorRepository.findByProfessorEmail(email)
                .map(professor -> professor.getProfessorPassword().equals(password))
                .orElse(false);
    }

}