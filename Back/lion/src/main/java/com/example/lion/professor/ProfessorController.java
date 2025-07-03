package com.example.lion.professor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> saveUser(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String department
    ) {
        ProfessorDTO user = professorService.addUser(name, password, email, department);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfessorDTO>> getAllUser() {
        List<ProfessorDTO> users = professorService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<ProfessorDTO> getUser(@RequestParam Long id) {
        ProfessorDTO user = professorService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping
    public ResponseEntity<ProfessorDTO> updateUser(@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO user = professorService.updateUser(professorDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id) {
        professorService.deleteUser(id);
        return ResponseEntity.ok("삭제 성공");
    }
}
