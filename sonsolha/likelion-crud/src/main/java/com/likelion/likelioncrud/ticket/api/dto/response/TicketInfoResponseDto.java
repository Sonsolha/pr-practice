package com.likelion.likelioncrud.ticket.api.dto.response;

import com.likelion.likelioncrud.ticket.domain.Ticket;
import lombok.Builder;

@Builder
public record TicketInfoResponseDto(
        String viewer,
        String seat,
        String movieTitle
) {
    public static TicketInfoResponseDto from(Ticket ticket) {
        return TicketInfoResponseDto.builder()
                .viewer(ticket.getViewer())  // 👈 추가됨!
                .seat(ticket.getTitle())
                .movieTitle(ticket.getMovie().getTitle())
                .build();
    }
}
