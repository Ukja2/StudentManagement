package com.example.lion.grade;

import com.example.lion.enrollment.EnrollmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<GradeDTO> addGrade(@RequestBody String gradeValue,
                                             @RequestParam EnrollmentEntity enrollment) {
        GradeDTO grade = gradeService.addGrade(gradeValue, enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(grade);
    }

    @GetMapping
    public ResponseEntity<List<GradeDTO>> getGrade() {
        List<GradeDTO> grade = gradeService.getAllGrade();
        return ResponseEntity.ok(grade);
    }

    @PatchMapping
    public ResponseEntity<GradeDTO> updateGrade(@RequestParam Long gradeId,
                                                @RequestParam String gradeValue,
                                                @RequestParam EnrollmentEntity enrollment) {
        GradeDTO grade = gradeService.updateGrade(gradeId, gradeValue, enrollment);
        return ResponseEntity.ok(grade);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGrade(@RequestParam EnrollmentEntity enrollment) {
        gradeService.deleteGrade(enrollment.getEnrollmentId());
        return ResponseEntity.ok("삭제 성공");
    }
}
