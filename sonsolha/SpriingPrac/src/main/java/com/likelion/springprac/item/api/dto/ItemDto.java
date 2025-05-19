package com.likelion.springprac.item.api.dto;

import lombok.Builder;

@Builder
public record ItemDto(
        Long id,
        String name,
        Long year
){}

