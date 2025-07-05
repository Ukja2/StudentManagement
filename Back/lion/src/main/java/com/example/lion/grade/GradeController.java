package com.example.lion.grade;

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
    public ResponseEntity<GradeDTO> addGrade(@RequestBody GradeDTO grade) {
        GradeDTO gradeDTO = gradeService.addGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).body(gradeDTO);
    }

    @GetMapping
    public ResponseEntity<List<GradeDTO>> getGrade() {
        List<GradeDTO> grade = gradeService.getAllGrade();
        return ResponseEntity.ok(grade);
    }

    @PatchMapping
    public ResponseEntity<GradeDTO> updateGrade(@RequestBody GradeDTO gradeDTO) {
        GradeDTO grade = gradeService.updateGrade(gradeDTO);
        return ResponseEntity.ok(grade);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGrade(@RequestBody GradeDTO gradeDTO) {
        gradeService.deleteGrade(gradeDTO);
        return ResponseEntity.ok("삭제 성공");
    }
}
