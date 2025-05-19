package com.likelion.likelioncrud.movie.application;

import java.util.List;

import com.likelion.likelioncrud.movie.api.dto.request.MovieSaveRequestDto;
import com.likelion.likelioncrud.movie.api.dto.response.MovieInfoResponseDto;
import com.likelion.likelioncrud.movie.api.dto.response.MovieListResponseDto;
import com.likelion.likelioncrud.movie.domain.Movie;
import com.likelion.likelioncrud.movie.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieService {
    private final MovieRepository movieRepository;

    // 영화 정보 저장
    @Transactional
    public void movieSave(MovieSaveRequestDto movieSaveRequestDto) {
        Movie movie = Movie.builder()
                .title(movieSaveRequestDto.title())
                .genre(movieSaveRequestDto.genre())
                .runningTime(movieSaveRequestDto.runningTime())
                .build();
        movieRepository.save(movie);
    }

    // 영화 모두 조회
    public MovieListResponseDto movieFindAll() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieInfoResponseDto> movieInfoResponseDtoList = movies.stream()
                .map(MovieInfoResponseDto::from)
                .toList();
        return MovieListResponseDto.from(movieInfoResponseDtoList);
    }

    // 단일 영화 조회
    public MovieInfoResponseDto movieFindOne(Long movieId) {
        Movie movie = movieRepository
                .findById(movieId)
                .orElseThrow(IllegalArgumentException::new);
        return MovieInfoResponseDto.from(movie);
    }
}
