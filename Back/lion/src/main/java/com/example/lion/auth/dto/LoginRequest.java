package com.example.lion.auth.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;       // 로그인 ID로 email을 사용
    private String password;
}
