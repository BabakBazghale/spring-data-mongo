package com.bob.projects.mongo.repository.impl;

import com.bob.projects.mongo.model.Movie;
import com.bob.projects.mongo.repository.MovieCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieCustomRepositoryImpl implements MovieCustomRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Movie> findMovieByData(String name, String subject, LocalDateTime releasedDate, Pageable page) {
        Query query = new Query().with(page);
        List<Criteria> criteria = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            criteria.add(Criteria.where("name").is(name));
        }
        if (subject != null && !subject.isEmpty()) {
            criteria.add(Criteria.where("subject").is(subject));
        }
        if (releasedDate != null) {
            criteria.add(Criteria.where("releasedDate").is(releasedDate));
        }
        if (!criteria.isEmpty()){
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return mongoTemplate.find(query, Movie.class);
    }
}
