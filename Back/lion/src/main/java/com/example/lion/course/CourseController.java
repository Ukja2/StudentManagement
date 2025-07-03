package com.example.lion.course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@RequestParam Long courseCode,
                                                @RequestParam String courseName) {
        CourseDTO courseDTO = courseService.addCourse(courseCode, courseName);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> getAllCourse() {
        List<CourseDTO> course = courseService.getAllCourse();
        return ResponseEntity.ok(course);
    }

    @PatchMapping
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO course = courseService.updateCourse(courseDTO);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCourse(@RequestParam Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("삭제성공");
    }
}
