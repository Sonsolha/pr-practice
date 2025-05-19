package com.likelion.likelioncrud.ticket.application;

import com.likelion.likelioncrud.movie.domain.Movie;
import com.likelion.likelioncrud.movie.domain.repository.MovieRepository;
import com.likelion.likelioncrud.ticket.api.dto.request.TicketSaveRequestDto;
import com.likelion.likelioncrud.ticket.api.dto.response.TicketInfoResponseDto;
import com.likelion.likelioncrud.ticket.api.dto.response.TicketListResponseDto;
import com.likelion.likelioncrud.ticket.domain.Ticket;
import com.likelion.likelioncrud.ticket.domain.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TicketService {

    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;

    // 예매 저장
    @Transactional
    public void ticketSave(TicketSaveRequestDto ticketSaveRequestDto) {
        Movie movie = movieRepository.findById(ticketSaveRequestDto.movieId())
                .orElseThrow(() -> new IllegalArgumentException("영화를 찾을 수 없습니다."));

        Ticket ticket = Ticket.builder()
                .title(ticketSaveRequestDto.title())
                .contents(ticketSaveRequestDto.contents())
                .viewer(ticketSaveRequestDto.viewer()) // ✅ viewer 포함!
                .movie(movie)
                .build();

        ticketRepository.save(ticket);
    }

    // 특정 영화의 예매 목록 조회
    public TicketListResponseDto findTicketsByMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("영화를 찾을 수 없습니다."));

        List<Ticket> tickets = ticketRepository.findByMovie(movie);
        List<TicketInfoResponseDto> ticketInfoResponseDtos = tickets.stream()
                .map(TicketInfoResponseDto::from)
                .toList();

        return TicketListResponseDto.from(ticketInfoResponseDtos);
    }
}
