package com.likelion.likelioncrud.ticket.api.dto.request;

public record TicketSaveRequestDto(
        Long movieId,
        String title,
        String contents,
        String viewer
) {
}
