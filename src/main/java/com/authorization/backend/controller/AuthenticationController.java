package com.authorization.backend.controller;

import com.authorization.backend.config.JwtTokenUtil;
import com.authorization.backend.entity.Member;
import com.authorization.backend.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;

    //인증 성공하면 인증 요청한 username이 들어간 token 발급
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Request request) {
        final Member member = userDetailsService.authenticateByUsernameAndPassword
                (request.getUsername(), request.password);
        final String token = jwtTokenUtil.generateToken(member.getUsername());
        return ResponseEntity.ok(new Response(token));
    }

    @Data
    static class Request {
        private String username;
        private String password;
    }

    @Data
    @AllArgsConstructor
    static class Response {
        private String token;
    }
}
