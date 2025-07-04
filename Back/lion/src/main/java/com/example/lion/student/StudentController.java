package com.example.lion.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<StudentEntity> getStudent(@RequestParam Long studentId) {
        StudentEntity studentEntity = studentService.getStudent(studentId);
        return ResponseEntity.ok(studentEntity);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestParam String studentName,
                                                 @RequestParam String studentPassword,
                                                 @RequestParam String studentEmail,
                                                 @RequestParam String department) {
        StudentDTO student = studentService.addStudent(studentName, studentPassword, studentEmail, department).toDTO();
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
