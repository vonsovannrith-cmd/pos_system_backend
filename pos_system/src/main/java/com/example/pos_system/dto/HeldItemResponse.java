package com.example.pos_system.dto;

import com.example.pos_system.dto.response.ProductResponse;

public record HeldItemResponse(

        ProductResponse product,
        int quantity
) {
}
