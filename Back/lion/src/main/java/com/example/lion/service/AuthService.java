package com.example.lion.service;

import com.example.lion.model.User;
import com.example.lion.model.Student;
import com.example.lion.model.Professor;
import com.example.lion.repository.UserRepository;
import com.example.lion.repository.StudentRepository;
import com.example.lion.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    public void registerStudent(String userName, String password, String email, String department, String studentNumber) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDepartment(department);
        user.setRole(User.Role.STUDENT);
        User savedUser = userRepository.save(user);

        Student student = new Student();
        student.setUser(savedUser);
        student.setStudentId(savedUser.getUserId());
        student.setStudentNumber(studentNumber);
        studentRepository.save(student);
    }

    public void registerProfessor(String userName, String password, String email, String department, String professorNumber) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDepartment(department);
        user.setRole(User.Role.PROFESSOR);
        User savedUser = userRepository.save(user);

        Professor professor = new Professor();
        professor.setUser(savedUser);
        professor.setProfessorId(savedUser.getUserId());
        professor.setProfessorNumber(professorNumber);
        professorRepository.save(professor);
    }

    public boolean login(String userName, String password) {
        return userRepository.findByUserName(userName)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}