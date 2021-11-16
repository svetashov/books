package com.example.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class BookModel {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "year")
    private Integer year;

    @JsonProperty(value = "authorId")
    private Long authorId;

}