package com.example.lion.grade;

import com.example.lion.enrollment.EnrollmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeDTO addGrade(String gradeValue, EnrollmentEntity enrollment) {
        GradeEntity grade = gradeRepository.save(GradeEntity.builder()
                .gradeValue(gradeValue)
                .enrollment(enrollment)
                .build());
        return grade.toDTO();
    }

    public List<GradeDTO> getAllGrade() {
        List<GradeEntity> grade = gradeRepository.findAll();
        List<GradeDTO> gradeDTO = new ArrayList<>();
        for(int i = 0; i < grade.size(); i++)
            gradeDTO.add(grade.get(i).toDTO());
        return gradeDTO;
    }

    public GradeDTO updateGrade(Long gradeId, String gradeValue, EnrollmentEntity enrollment) {
        GradeEntity grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new RuntimeException("Grade not found"));
        grade.setGradeValue(gradeValue);
        grade.setEnrollment(enrollment);
        return gradeRepository.save(grade).toDTO();
    }

    public void deleteGrade(Long enrollment) {
        gradeRepository.deleteById(enrollment);
    }
}
