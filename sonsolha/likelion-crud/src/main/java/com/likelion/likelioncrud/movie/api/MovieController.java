package com.likelion.likelioncrud.movie.api;

import com.likelion.likelioncrud.movie.api.dto.request.MovieSaveRequestDto;
import com.likelion.likelioncrud.movie.api.dto.response.MovieInfoResponseDto;
import com.likelion.likelioncrud.movie.api.dto.response.MovieListResponseDto;
import com.likelion.likelioncrud.movie.application.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    // 영화 저장
    @PostMapping("/save")
    public ResponseEntity<String> movieSave(@RequestBody MovieSaveRequestDto movieSaveRequestDto) {
        movieService.movieSave(movieSaveRequestDto);
        return new ResponseEntity<>("영화 저장 완료!", HttpStatus.CREATED);
    }

    // 영화 전체 조회
    @GetMapping("/all")
    public ResponseEntity<MovieListResponseDto> movieFindAll() {
        MovieListResponseDto movieListResponseDto = movieService.movieFindAll();
        return new ResponseEntity<>(movieListResponseDto, HttpStatus.OK);
    }

    // 영화 id로 특정 영화 조회
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieInfoResponseDto> movieFindOne(@PathVariable("movieId") Long movieId) {
        MovieInfoResponseDto movieInfoResponseDto = movieService.movieFindOne(movieId);
        return new ResponseEntity<>(movieInfoResponseDto, HttpStatus.OK);
    }
}
