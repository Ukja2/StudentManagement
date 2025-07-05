package com.example.lion.professor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<ProfessorDTO> saveProfessor(@RequestParam String professorName,
                                                      @RequestParam String professorPassword,
                                                      @RequestParam String professorEmail,
                                                      @RequestParam String professorDepartment) {
        ProfessorDTO professor = professorService.addProfessor(professorName, professorPassword, professorEmail, professorDepartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfessorDTO>> getAllProfessor() {
        List<ProfessorEntity> entityList = professorRepository.findAll();
        List<ProfessorDTO> dtoList = new ArrayList<>();

        for (ProfessorEntity entity : entityList) {
            dtoList.add(entity.toDTO());
        }

        return ResponseEntity.ok(dtoList);
    }


    @GetMapping
    public ResponseEntity<ProfessorDTO> getProfessor(@RequestParam Long professorId) {
        ProfessorDTO professor = professorService.getProfessor(professorId);
        return ResponseEntity.ok(professor);
    }

    @PatchMapping
    public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO professor = professorService.updateProfessor(professorDTO);
        return ResponseEntity.ok(professor);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProfessor(@RequestParam Long professorId) {
        professorService.deleteProfessor(professorId);
        return ResponseEntity.ok("삭제 성공");
    }
}
