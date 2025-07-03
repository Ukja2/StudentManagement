package com.example.lion.service;

import com.example.lion.model.Student;
import com.example.lion.model.User;
import com.example.lion.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public Student updateStudent(Long userId, Student updatedStudentData) {
        Student existingStudent = studentRepository.findById(userId).orElseThrow();

        // User 정보 업데이트
        User user = existingStudent.getUser();
        user.setUserName(updatedStudentData.getUser().getUserName());
        user.setPassword(updatedStudentData.getUser().getPassword());
        user.setDepartment(updatedStudentData.getUser().getDepartment());

        // studentNumber 등 Student 고유 필드 업데이트
        existingStudent.setStudentNumber(updatedStudentData.getStudentNumber());

        // userRepository.save(user) 필요 시 호출 (cascade 설정에 따라 다름)
        // studentRepository.save(existingStudent) 저장
        return studentRepository.save(existingStudent);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // 로그인 기능 추가 (id와 password 비교)
    public boolean login(String studentNumber, String password) {
        Optional<Student> studentOpt = studentRepository.findByStudentNumber(studentNumber);

        return studentOpt
                .map(student -> {
                    User user = student.getUser();
                    return user != null && user.getPassword().equals(password);
                })
                .orElse(false);
    }


}
