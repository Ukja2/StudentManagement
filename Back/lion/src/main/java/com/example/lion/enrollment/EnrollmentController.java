package com.example.lion.enrollment;


import com.example.lion.course.CourseEntity;
import com.example.lion.student.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;


    @GetMapping("/all")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollment() {
        List<EnrollmentDTO> enrollment = enrollmentService.getAllEnrollment();
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> saveEnrollment(@RequestParam StudentEntity student,
                                                        @RequestParam CourseEntity course) {
        EnrollmentDTO enrollmentDTO = enrollmentService.addEnrollment(student, course);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentDTO);
    }

    @PatchMapping
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@RequestParam Long enrollmentId,
                                                          @RequestParam StudentEntity student,
                                                          @RequestParam CourseEntity course) {
        EnrollmentDTO enrollment = enrollmentService.updateEnrollment(enrollmentId, student, course);
        return ResponseEntity.ok(enrollment);
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteEnrollment(@RequestParam Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.ok(enrollmentId);
    }



}
