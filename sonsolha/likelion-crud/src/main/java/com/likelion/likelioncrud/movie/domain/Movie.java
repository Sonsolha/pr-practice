package com.likelion.likelioncrud.movie.domain;

import com.likelion.likelioncrud.ticket.domain.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    private String title;

    private String genre;

    private int runningTime;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    @Builder
    public Movie(String title, String genre, int runningTime) {
        this.title = title;
        this.genre = genre;
        this.runningTime = runningTime;
    }
}
