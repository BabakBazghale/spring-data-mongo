package com.bob.projects.mongo.repository;

import com.bob.projects.mongo.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ActorRepository extends MongoRepository<Actor, String> {
    @Query("{ 'age' : { $gt: ?0, $lt: ?1 } }")
    List<Actor> findByAgeBetween(int ageGT, int ageLT);

    @Query("{ 'name' : { $regex: ?0 } }")
    List<Actor> findByNameRegex(String regexp);

    boolean existsByFamilyIn(List<String> family);
}
