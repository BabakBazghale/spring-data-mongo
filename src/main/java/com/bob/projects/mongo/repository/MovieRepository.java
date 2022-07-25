package com.bob.projects.mongo.repository;

import com.bob.projects.mongo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<Movie, String>{
    @Query("{ 'name' : ?0 }")
    List<Movie> findByName(String name);
    @Query("{ 'name' : { $regex: ?0 } }")
    List<Movie> findByNameRegex(String regexp);

    List<Movie> findByNameLikeOrderByReleasedDate(String name);

    List<Movie> findByNameStartingWith(String regexp);

    List<Movie> findByNameEndingWith(String regexp);
}
