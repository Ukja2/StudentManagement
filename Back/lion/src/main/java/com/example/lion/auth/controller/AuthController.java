package com.example.lion.auth.controller;

import com.example.lion.auth.dto.LoginRequest;
import com.example.lion.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register/student")
    public String registerStudent(@RequestBody Map<String, String> body) {
        authService.registerStudent(
                body.get("userName"),
                body.get("password"),
                body.get("email"),
                body.get("department")
        );
        return "학생 등록 완료";
    }

    @PostMapping("/register/professor")
    public String registerProfessor(@RequestBody Map<String, String> body) {
        authService.registerProfessor(
                body.get("userName"),
                body.get("password"),
                body.get("email"),
                body.get("department")
        );
        return "교수 등록 완료";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();

        if (authService.existsStudent(email)) {
            boolean result = authService.loginStudent(email, password);
            return result ?
                    ResponseEntity.ok("학생 로그인 성공!") :
                    ResponseEntity.badRequest().body("학생 로그인 실패");
        } else {
            boolean result = authService.loginProfessor(email, password);
            return result ?
                    ResponseEntity.ok("교수 로그인 성공!") :
                    ResponseEntity.badRequest().body("교수 로그인 실패");
        }
    }
}