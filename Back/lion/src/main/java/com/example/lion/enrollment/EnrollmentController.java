package com.example.lion.enrollment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @GetMapping("/all")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollment() {
        List<EnrollmentDTO> enrollment = enrollmentService.getAllEnrollment();
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> saveEnrollment(@RequestBody EnrollmentDTO enrollment) {
        EnrollmentDTO enrollmentDTO = enrollmentService.addEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentDTO);
    }

    @PatchMapping
    public ResponseEntity<EnrollmentDTO> updateEnrollment(@RequestBody EnrollmentDTO enrollment) {
        EnrollmentDTO enrollmentDTO = enrollmentService.updateEnrollment(enrollment);
        return ResponseEntity.ok(enrollmentDTO);
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteEnrollment(@RequestParam Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.ok(enrollmentId);
    }



}
