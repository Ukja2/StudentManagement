package com.example.lion.auth.controller;

import com.example.lion.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/student")
    public String registerStudent(@RequestBody Map<String, String> body) {
        authService.registerStudent(
                body.get("userName"),
                body.get("password"),
                body.get("email"),
                body.get("department"),
                body.get("studentNumber")
        );
        return "학생 등록 완료";
    }

    @PostMapping("/register/professor")
    public String registerProfessor(@RequestBody Map<String, String> body) {
        authService.registerProfessor(
                body.get("userName"),
                body.get("password"),
                body.get("email"),
                body.get("department"),
                body.get("professorNumber")
        );
        return "교수 등록 완료";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body) {
        boolean result = authService.login(body.get("userName"), body.get("password"));
        return result ? "로그인 성공" : "로그인 실패";
    }
}