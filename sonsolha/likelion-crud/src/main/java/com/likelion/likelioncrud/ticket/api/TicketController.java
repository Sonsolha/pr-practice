package com.likelion.likelioncrud.ticket.api;

import com.likelion.likelioncrud.ticket.api.dto.request.TicketSaveRequestDto;
import com.likelion.likelioncrud.ticket.api.dto.response.TicketListResponseDto;
import com.likelion.likelioncrud.ticket.application.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    // 예매 저장
    @PostMapping("/save")
    public ResponseEntity<String> ticketSave(@RequestBody TicketSaveRequestDto ticketSaveRequestDto) {
        ticketService.ticketSave(ticketSaveRequestDto);
        return new ResponseEntity<>("🎟 예매 완료!", HttpStatus.CREATED);
    }

    // 영화 ID를 기준으로 해당 영화의 예매 목록 조회
    @GetMapping("/{movieId}")
    public ResponseEntity<TicketListResponseDto> findTicketsByMovie(@PathVariable("movieId") Long movieId) {
        TicketListResponseDto ticketListResponseDto = ticketService.findTicketsByMovie(movieId);
        return new ResponseEntity<>(ticketListResponseDto, HttpStatus.OK);
    }
}
