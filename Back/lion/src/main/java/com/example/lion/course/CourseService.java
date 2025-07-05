package com.example.lion.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseDTO addCourse(CourseDTO course) {
        return courseRepository.save(CourseEntity.builder()
                        .courseCode(course.getCourseCode())
                .courseName(course.getCourseName())
                        .professor(course.getProfessor())
                .build())
                .toDTO();
    }

    public List<CourseDTO> getAllCourse() {
        return courseRepository.findAll()
                .stream()
                .map(CourseEntity::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO updateCourse(CourseDTO courseDTO) {
        CourseEntity course = courseRepository.findById(courseDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course Not Found"));
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseName(courseDTO.getCourseName());
        course.setProfessor(courseDTO.getProfessor());
        return courseRepository.save(course).toDTO();
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
