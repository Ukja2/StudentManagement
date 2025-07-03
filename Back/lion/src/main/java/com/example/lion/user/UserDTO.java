package com.example.lion.user;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String department;
    private UserEntity.UserRole role;
}
