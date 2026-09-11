package com.example.auth;


import com.example.auth.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // REGISTER
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request) {

        String result = authService.register(
                request.email(),
                request.password(),
                request.role()
        );

        return ResponseEntity.ok(result);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request) {

        String token = authService.login(
                request.email(),
                request.password()
        );

        return ResponseEntity.ok(token);
    }

    public record RegisterRequest(
            String email,
            String password,
            String role
    ) {}

    public record LoginRequest(
            String email,
            String password
    ) {}
}