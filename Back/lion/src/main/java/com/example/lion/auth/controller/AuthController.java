package com.example.lion.auth.controller;

import com.example.lion.auth.dto.LoginRequest;
import com.example.lion.auth.dto.RegisterRequest;
import com.example.lion.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/student")
    public String registerStudent(@RequestBody RegisterRequest request) {
        authService.registerStudent(
                request.getName(),
                request.getEmail(),
                request.getDepartment(),
                request.getNumber(),
                request.getPassword()
        );
        return "학생 등록 완료";
    }

    @PostMapping("/register/professor")
    public String registerProfessor(@RequestBody RegisterRequest request) {
        authService.registerProfessor(
                request.getName(),
                request.getEmail(),
                request.getDepartment(),
                request.getNumber(),
                request.getPassword()
        );
        return "교수 등록 완료";
    }

    @PostMapping("/login/student")
    public String loginStudent(@RequestBody LoginRequest request) {
        boolean result = authService.loginStudent(request.getEmail(), request.getPassword());
        return result ? "학생 로그인 성공" : "로그인 실패";
    }

    @PostMapping("/login/professor")
    public String loginProfessor(@RequestBody LoginRequest request) {
        boolean result = authService.loginProfessor(request.getEmail(), request.getPassword());
        return result ? "교수 로그인 성공" : "로그인 실패";
    }
}
