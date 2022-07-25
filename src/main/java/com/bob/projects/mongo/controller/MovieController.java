package com.bob.projects.mongo.controller;


import com.bob.projects.mongo.dto.ActorResponseDTO;
import com.bob.projects.mongo.dto.MovieResponseDTO;
import com.bob.projects.mongo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/movie/creation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieResponseDTO> movieCreation() {
        return movieService.movieCreation();
    }

    @PostMapping(value = "/actor/creation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActorResponseDTO>> actorsCreation() {
        return movieService.actorsCreation();
    }

    @GetMapping(value = "/actor/fetch-by-age")
    public ResponseEntity<List<ActorResponseDTO>> actorsCreation(@RequestParam Integer minAge,
                                                                 @RequestParam Integer maxAge) {
        return movieService.fetchActorsByAge(minAge,maxAge );
    }
}
