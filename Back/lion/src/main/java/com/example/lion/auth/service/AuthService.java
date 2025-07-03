package com.example.lion.auth.service;

import com.example.lion.professor.ProfessorEntity;
import com.example.lion.student.StudentEntity;
import com.example.lion.student.StudentRepository;
import com.example.lion.user.UserEntity;
import com.example.lion.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public void registerStudent(String userName, String password, String email, String department, String studentNumber) {
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setDepartment(department);
        user.setRole(UserEntity.Role.STUDENT);
        UserEntity savedUser = userRepository.save(user);

        StudentEntity student = new StudentEntity();
        student.setUser(savedUser);
        student.setStudentId(savedUser.getUserId());
        student.setStudentNumber(studentNumber);
        studentRepository.save(student);
    }

    public boolean login(String userName, String password) {
        return userRepository.findByUserName(userName)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}