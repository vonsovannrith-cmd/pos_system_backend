package com.example.pos_system.dto;

import java.time.LocalDateTime;

public record HeldCartSummary(

        Long id,
        String label,
        int itemCount,
        int totalQuantity,
        LocalDateTime createdAt
) {
}
