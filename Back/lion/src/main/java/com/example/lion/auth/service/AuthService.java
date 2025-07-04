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

    public void registerStudent(String userName, String password, String email, String department, String studentNumber) {
        ProfessorEntity user = new ProfessorEntity();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDepartment(department);
        user.setRole(ProfessorEntity.Role.STUDENT);
        ProfessorEntity savedUser = professorRepository.save(user);

        StudentEntity student = new StudentEntity();
        student.setUser(savedUser);
        student.setStudentId(savedUser.getId());
        student.setStudentNumber(studentNumber);
        studentRepository.save(student);
    }

    public boolean login(String userName, String password) {
        return professorRepository.findByUserName(userName)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}