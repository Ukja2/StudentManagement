package com.example.lion.professor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorDTO addUser(String name, String password, String email, String department) {
        return professorRepository.save(ProfessorEntity.builder()
                .name(name)
                .password(password)
                .email(email)
                .department(department)
                .build())
                .toDTO();
    }

    public List<ProfessorDTO> getAllUser() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorEntity::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO getUser(Long userId) {
        ProfessorEntity user = professorRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.toDTO();
    }

    public ProfessorDTO updateUser(ProfessorDTO professorDTO) {
        ProfessorEntity user = professorRepository.findById(professorDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(professorDTO.getName());
        user.setPassword(professorDTO.getPassword());
        user.setEmail(professorDTO.getEmail());
        user.setDepartment(professorDTO.getDepartment());
        return professorRepository.save(user).toDTO();
    }

    public void deleteUser(Long userId) {
        professorRepository.deleteById(userId);
    }
}
