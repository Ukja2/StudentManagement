package com.example.lion.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<StudentEntity> getStudent(@RequestParam Long studentId) {
        StudentEntity studentEntity = studentService.getStudent(studentId);
        return ResponseEntity.ok(studentEntity);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestParam String studentName, @RequestParam String studentNum, @RequestParam String studentEmail) {
        StudentDTO student = studentService.addStudent(studentName, studentNum, studentEmail).toDTO();
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
