package com.example.pos_system.dto.response;

public record AuthResponse(

        String token,
        String tokenType,
        String fullName,
        String email,
        String role
) {
}
