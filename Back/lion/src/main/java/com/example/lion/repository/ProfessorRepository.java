package com.example.lion.repository;

import com.example.lion.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByProfessorId(Long professorId);

    Optional<Professor> findByProfessorNumber(String professorNumber);
}
