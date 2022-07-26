package com.bob.projects.mongo.repository;

import com.bob.projects.mongo.model.Movie;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieCustomRepository {

    List<Movie> findMovieByData(String name, String subject, LocalDateTime releasedDate
            , Pageable page);
}
