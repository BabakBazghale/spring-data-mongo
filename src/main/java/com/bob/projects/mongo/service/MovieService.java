package com.bob.projects.mongo.service;

import com.bob.projects.mongo.model.Movie;
import com.bob.projects.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
//    @Transactional
    public Movie userPersistence(){
        Movie movie = Movie.builder().age(12).emailAddress("sd").name("sda").build();
        userRepository.insert(movie);
        return movie;
    }

    public List<Movie> fetchUser(){
        return userRepository.findByName("sda");
    }
}
