package com.example.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchCriteria {

    private String name;

    private Integer year;

    private Long authorId;

}
