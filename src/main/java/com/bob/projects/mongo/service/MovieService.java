package com.bob.projects.mongo.service;

import com.bob.projects.mongo.dto.ActorResponseDTO;
import com.bob.projects.mongo.dto.MovieResponseDTO;
import com.bob.projects.mongo.exception.DuplicateDataException;
import com.bob.projects.mongo.model.Actor;
import com.bob.projects.mongo.model.Movie;
import com.bob.projects.mongo.repository.ActorRepository;
import com.bob.projects.mongo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    public ResponseEntity<MovieResponseDTO> movieCreation() {
        Movie movie = Movie.builder()
                .name("LaLa Land")
                .subject("musical comedy-drama")
                .releasedDate(LocalDateTime.now())
                .actorList(fetchActors()).build();
        if (fetchMovieByName(movie.getName())) {
            throw new DuplicateDataException("duplicate data exception raised.");
        }
        movieRepository.insert(movie);
        return ResponseEntity.ok(new MovieResponseDTO(movie));
    }

    public ResponseEntity<List<ActorResponseDTO>> actorsCreation() {
        List<Actor> actorList = actorsGeneration();
        if (fetchActorByFamily(
                actorList.stream().map(x -> x.getFamily()).collect(Collectors.toList()))) {
            throw new DuplicateDataException("duplicate data exception raised.");
        }
        actorRepository.insert(actorList);
        return ResponseEntity.ok(actorList.stream().map(ActorResponseDTO::new).collect(Collectors.toList()));
    }

    private List<Actor> actorsGeneration() {
        Actor ryan = Actor.builder()
                .name("Ryan")
                .family("Gosling")
                .gender("male")
                .age(41).build();
        Actor emma = Actor.builder()
                .name("Emma")
                .family("Stone")
                .gender("female")
                .age(33).build();
        return Arrays.asList(ryan, emma);
    }

    public List<Actor> fetchActors() {
        return actorRepository.findByAgeBetween(20, 40);
    }
    public  ResponseEntity<List<ActorResponseDTO>>fetchActorsByAge(Integer minAge,Integer maxAge) {
        return ResponseEntity.ok(actorRepository.findByAgeBetween(minAge, maxAge)
                .stream().map(ActorResponseDTO::new).collect(Collectors.toList()));
    }

    public boolean fetchMovieByName(String name) {
        return movieRepository.existsByName(name);
    }

    public boolean fetchActorByFamily(List<String> familyList) {
        return actorRepository.existsByFamilyIn(familyList);
    }
}
