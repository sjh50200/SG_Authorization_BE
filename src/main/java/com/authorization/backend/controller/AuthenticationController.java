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

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request) {
        final Member member = userDetailsService.authenticateByUsernameAndPassword
                (request.getUsername(), request.password);
        final String token = "token";
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Data
    static class JwtRequest {
        private String username;
        private String password;
    }

    @Data
    @AllArgsConstructor
    static class JwtResponse {
        private String token;
    }
}
