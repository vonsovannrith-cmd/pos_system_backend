package com.example.pos_system.controller;

import com.example.pos_system.dto.auth.ChangePasswordRequest;
import com.example.pos_system.dto.request.LoginRequest;
import com.example.pos_system.dto.response.AuthResponse;
import com.example.pos_system.dto.response.UserResponse;
import com.example.pos_system.model.service.auth.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request, HttpServletRequest http) {
        return authService.login(request, http.getRemoteAddr());
    }

    @GetMapping("/me")
    public UserResponse me(Authentication authentication) { // This object is automatically retrieved from the SecurityContextHolder (which is populated by the JwtAuthenticationFilter when a user sends a token in the request header).
        return authService.me(authentication.getName()); // Generally, it retrieves the username (which, in your code, is the email) of the user who has successfully completed token authentication.
    }

    @PostMapping("/change-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@Valid @RequestBody ChangePasswordRequest request,
                               Authentication authentication) {
        authService.changePassword(authentication.getName(), request);
    }
}
