package com.example.books.controller;

import com.example.books.entity.Author;
import com.example.books.entity.Book;
import com.example.books.model.BookModel;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository _bookRepository;
    private final AuthorRepository _authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        _bookRepository = bookRepository;
        _authorRepository = authorRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Book>> getBooks() {
        Iterable<Book> books = _bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookModel bookModel) {
        Author author = _authorRepository
                .findById(bookModel.getAuthorId())
                .orElseThrow(RuntimeException::new);

        Book book = new Book(bookModel.getName(), bookModel.getYear(), author);
        _bookRepository.save(book);

        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

}
