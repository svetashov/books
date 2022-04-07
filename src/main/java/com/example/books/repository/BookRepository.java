package com.example.books.repository;

import com.example.books.entity.Author;
import com.example.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByNameAndAuthor(String name, Author author);

}
