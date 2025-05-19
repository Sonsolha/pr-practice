package com.likelion.likelioncrud.movie.api.dto.request;

public record MovieSaveRequestDto(
        String title,
        String genre,
        int runningTime
) {}
