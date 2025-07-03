package com.example.lion.service;

import com.example.lion.model.Professor;
import com.example.lion.model.User;
import com.example.lion.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> getAllprofessors(){
        return professorRepository.findAll();
    }

    public Professor getProfessor(Long id){
        return professorRepository.findById(id).orElseThrow();
    }

    public Professor createProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor professor) {
        Professor existing = professorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 교수 ID가 존재하지 않습니다."));

        // 연결된 User 정보 수정
        User existingUser = existing.getUser();
        User incomingUser = professor.getUser();

        if (existingUser != null && incomingUser != null) {
            existingUser.setUserName(incomingUser.getUserName());
            existingUser.setDepartment(incomingUser.getDepartment());
            existingUser.setPassword(incomingUser.getPassword());
            existingUser.setEmail(incomingUser.getEmail()); // 필요시
        }

        // 교수 번호도 업데이트
        existing.setProfessorNumber(professor.getProfessorNumber());

        return professorRepository.save(existing);
    }


    public void deleteProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
