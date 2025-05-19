package com.likelion.likelioncrud.ticket.domain;

import com.likelion.likelioncrud.movie.domain.Movie;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long id;

    private String title;
    private String contents;

    private String viewer;  // 👈 viewer 필드 추가!!

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Builder
    public Ticket(String title, String contents, Movie movie, String viewer) {
        this.title = title;
        this.contents = contents;
        this.movie = movie;
        this.viewer = viewer;
    }
}
