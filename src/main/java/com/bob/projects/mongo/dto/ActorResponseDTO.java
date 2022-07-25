package com.bob.projects.mongo.dto;

import com.bob.projects.mongo.model.Actor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ActorResponseDTO {
    private String actorId;
    private String actorName;
    private String actorFamily;
    private Integer actorAge;
    private String actorGender;

    public ActorResponseDTO(Actor actor) {
        this.actorId = actor.getId();
        this.actorName = actor.getName();
        this.actorFamily = actor.getFamily();
        this.actorAge = actor.getAge();
        this.actorGender = actor.getGender();
    }
}
