package com.bob.projects.mongo.dto;

import com.bob.projects.mongo.model.Actor;
import com.bob.projects.mongo.model.Movie;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieResponseDTO {
    private String movieId;
    private String movieName;
    private String movieSubject;
    private LocalDateTime movieReleasedDate;
    private List<Actor> actors;

    public MovieResponseDTO(Movie movie) {
        this.movieId = movie.getId();
        this.movieName = movie.getName();
        this.movieSubject = movie.getSubject();
        this.movieReleasedDate = movie.getReleasedDate();
        this.actors = movie.getActorList();
    }
}
