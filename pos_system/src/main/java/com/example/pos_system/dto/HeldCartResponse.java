package com.example.pos_system.dto;

import java.util.List;

public record HeldCartResponse(

        Long id,
        String label,
        List<HeldItemResponse> items
) {
}
