package com.example.lion.enrollment;

import com.example.lion.course.CourseEntity;
import com.example.lion.student.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentDTO addEnrollment(StudentEntity student, CourseEntity course) {
      return enrollmentRepository.save(EnrollmentEntity.builder()
              .student(student)
              .course(course)
              .build())
              .toDTO();
    }

    public List<EnrollmentDTO> getAllEnrollment() {
        return enrollmentRepository.findAll().stream().map(EnrollmentEntity::toDTO).collect(Collectors.toList());
    }

    public EnrollmentDTO updateEnrollment(Long enrollmentId, StudentEntity student, CourseEntity course) {
        EnrollmentEntity enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(()-> new RuntimeException("X"));
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollmentRepository.save(enrollment).toDTO();
    }
    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
