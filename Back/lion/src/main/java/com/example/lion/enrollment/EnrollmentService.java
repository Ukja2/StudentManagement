package com.example.lion.enrollment;

import com.example.lion.course.CourseEntity;
import com.example.lion.course.CourseRepository;
import com.example.lion.student.StudentEntity;
import com.example.lion.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentDTO addEnrollment(EnrollmentDTO enrollmentDTO) {
        StudentEntity student = studentRepository.findById(enrollmentDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        CourseEntity course = courseRepository.findById(enrollmentDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        EnrollmentEntity saved = enrollmentRepository.save(
                EnrollmentEntity.builder()
                        .student(student)
                        .course(course)
                        .build()
        );
        return saved.toDTO();
    }

    public List<EnrollmentDTO> getAllEnrollment() {
        return enrollmentRepository.findAll().stream().map(EnrollmentEntity::toDTO).collect(Collectors.toList());
    }

    public EnrollmentDTO updateEnrollment(EnrollmentDTO enrollmentDTO) {
        EnrollmentEntity enrollment = enrollmentRepository.findById(enrollmentDTO.getEnrollmentId())
                .orElseThrow(()-> new RuntimeException("Enrollment not found"));
        enrollment.setStudent(studentRepository.findById(enrollmentDTO.getStudentId())
                .orElseThrow(()-> new RuntimeException("Student not found")));
        enrollment.setCourse(courseRepository.findById(enrollmentDTO.getCourseId())
                .orElseThrow(()-> new RuntimeException("Course not found")));
        return enrollmentRepository.save(enrollment).toDTO();
    }
    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
