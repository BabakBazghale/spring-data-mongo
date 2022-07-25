package com.bob.projects.mongo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Actor {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Indexed(unique = true)
    private String family;
    private Integer age;
    private String gender;
@Builder
    public Actor(String name, String family, Integer age, String gender) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.gender = gender;
    }
}
