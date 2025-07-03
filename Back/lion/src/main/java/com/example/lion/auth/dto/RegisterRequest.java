package com.example.lion.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;         // 이름
    private String password;     // 비밀번호
    private String email;        // 이메일
    private String department;   // 학과
    private String number;       // 학번 또는 교수번호 (학생/교수 구분 없이 사용)
}
