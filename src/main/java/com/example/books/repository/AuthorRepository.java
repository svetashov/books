package com.example.books.repository;

import com.example.books.entity.Author;
import com.example.books.entity.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByFullName(String fullName);
}
