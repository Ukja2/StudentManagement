package com.example.lion.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String id;
    private String password;
    private String name;
    private String department; // 학과 필드 추가
}
