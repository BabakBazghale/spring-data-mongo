package com.bob.projects.mongo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class MovieRequestDTO {
    @NotNull
    @Length(min = 3, max = 15)
    private String name;

    @NotNull
    @Length(min = 3, max = 15)
    private String subject;

}
