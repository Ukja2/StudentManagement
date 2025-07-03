package com.example.lion.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO addUser(String userName, String password, String email, String department, UserEntity.UserRole role) {
        return userRepository.save(UserEntity.builder()
                .userName(userName)
                .password(password)
                .email(email)
                .department(department)
                .role(role)
                .build())
                .toDTO();
    }

    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserEntity::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.toDTO();
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity user = userRepository.findById(userDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setDepartment(userDTO.getDepartment());
        user.setRole(userDTO.getRole());
        return userRepository.save(user).toDTO();
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
