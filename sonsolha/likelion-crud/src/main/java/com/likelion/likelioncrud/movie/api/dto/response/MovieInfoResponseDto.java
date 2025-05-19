package com.likelion.likelioncrud.movie.api.dto.response;

import com.likelion.likelioncrud.movie.domain.Movie;
import lombok.Builder;

@Builder
public record MovieInfoResponseDto(
        Long movieId,
        String title,
        String genre,
        int runningTime
) {
    public static MovieInfoResponseDto from(Movie movie) {
        return MovieInfoResponseDto.builder()
                .movieId(movie.getId())         // 여기가 핵심! id 필드명 기준!
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .runningTime(movie.getRunningTime())
                .build();
    }
}
