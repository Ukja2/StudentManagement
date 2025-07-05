package com.example.lion.grade;

import com.example.lion.enrollment.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final EnrollmentRepository enrollmentRepository;

    public GradeDTO addGrade(GradeDTO gradeDTO) {
        GradeDTO grade = gradeRepository.save(GradeEntity.builder()
                .gradeValue(gradeDTO.getGradeValue())
                .enrollment(enrollmentRepository.findById(gradeDTO.getEnrollment())
                        .orElseThrow(() -> new RuntimeException("Enrollment not found")))
                .build()).toDTO();
        return grade;
    }

    public List<GradeDTO> getAllGrade() {
        List<GradeEntity> grade = gradeRepository.findAll();
        List<GradeDTO> gradeDTO = new ArrayList<>();
        for(int i = 0; i < grade.size(); i++)
            gradeDTO.add(grade.get(i).toDTO());
        return gradeDTO;
    }

    public GradeDTO updateGrade(GradeDTO gradeDTO) {
        GradeEntity grade = gradeRepository.findById(gradeDTO.getGradeId())
                .orElseThrow(() -> new RuntimeException("Grade not found"));
        grade.setGradeValue(gradeDTO.getGradeValue());
        grade.setEnrollment(enrollmentRepository.findById(gradeDTO.getEnrollment())
                .orElseThrow(() -> new RuntimeException("Enrollment not found")));
        return gradeRepository.save(grade).toDTO();
    }

    public void deleteGrade(GradeDTO grade) {
        gradeRepository.deleteById(grade.getEnrollment());
    }
}
