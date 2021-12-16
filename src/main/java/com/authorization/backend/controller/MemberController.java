package com.authorization.backend.controller;

import com.authorization.backend.entity.Member;
import com.authorization.backend.entity.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(memberRepository.save(Member.createMember(memberDto.getUsername(), passwordEncoder.encode(memberDto.getPassword()))));
    }

    @Data
    public static class MemberDto {
        private String username;
        private String password;
    }
}
