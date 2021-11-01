package com.example.books.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
public class BookModel {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "year")
    private int year;
    @JsonProperty(value = "authorId")
    private Long authorId;
}