package com.bob.projects.mongo.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@QueryEntity
@Document
@Data
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String subject;
    private LocalDateTime releasedDate;
    @Field("actor")
    private List<Actor> actorList;

    @Builder
    public Movie(String name, String subject, LocalDateTime releasedDate, List<Actor> actorList) {
        this.name = name;
        this.subject = subject;
        this.releasedDate = releasedDate;
        this.actorList = actorList;
    }
}
