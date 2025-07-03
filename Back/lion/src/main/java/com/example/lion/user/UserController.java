package com.example.lion.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(
            @RequestParam String userName,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String department,
            @RequestParam UserEntity.UserRole role
    ) {
        UserDTO user = userService.addUser(userName, password, email, department, role);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUser(@RequestParam Long userId) {
        UserDTO user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PatchMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.updateUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("삭제 성공");
    }
}
