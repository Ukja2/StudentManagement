package com.example.lion.professor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorDTO addProfessor(String professorName, String professorPassword, String professorEmail, String professorDepartment) {
        return professorRepository.save(ProfessorEntity.builder()
                .professorName(professorName)
                .professorPassword(professorPassword)
                .professorEmail(professorEmail)
                .professorDepartment(professorDepartment)
                .build())
                .toDTO();
    }

    public List<ProfessorDTO> getAllUser() {
        List<ProfessorEntity> professor = professorRepository.findAll();
        List<ProfessorDTO> professorDTO = new ArrayList<>();
        for (int i = 0; i<=professor.size(); i++) {
            professorDTO.add(professor.get(i).toDTO());
        }
        return professorDTO;
    }

    public ProfessorDTO getProfessor(Long professorId) {
        ProfessorEntity professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        return professor.toDTO();
    }

    public ProfessorDTO updateProfessor(ProfessorDTO professorDTO) {
        ProfessorEntity professor = professorRepository.findById(professorDTO.getProfessorId())
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        professor.setProfessorName(professorDTO.getProfessorName());
        professor.setProfessorEmail(professorDTO.getProfessorEmail());
        professor.setProfessorDepartment(professorDTO.getProfessorDepartment());
        return professorRepository.save(professor).toDTO();
    }

    public void deleteProfessor(Long professorId) {
        professorRepository.deleteById(professorId);
    }
}
