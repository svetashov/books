package com.example.books.model;

import com.example.books.entity.Author;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class BookModel {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "year")
    private int year;
    @JsonProperty(value = "authorId")
    private Long authorId;
}