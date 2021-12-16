package com.authorization.backend.controller;

import com.authorization.backend.dto.AccountSaveRequestDto;
import com.authorization.backend.repository.AccountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AccountRepository accountRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getId() + userDTO.getPassword());

        return ResponseEntity.ok(accountRepository.save(user));
    }

    @GetMapping("/signin")
    public String signIn(AccountSaveRequestDto requestDto)

    @Getter
    private static class UserDTO {
        private String id;
        private String password;
    }
}
