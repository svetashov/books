package com.example.books.controller;

import com.example.books.dto.PageDto;
import com.example.books.entity.Book;
import com.example.books.model.BookModel;
import com.example.books.model.BookSearchCriteria;
import com.example.books.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getBooks(PageDto pageDto) {
        return new ResponseEntity<>(bookService.getBooks(pageDto), HttpStatus.OK);
    }

    @GetMapping("/authors")     // так делать не надо!!! это для примера
    public ResponseEntity<Page<Book>> getBooksByAuthorId(PageDto pageDto, @RequestParam Long authorId) {
        return new ResponseEntity<>(bookService.getBooksByAuthorId(pageDto, authorId), HttpStatus.OK);
    }

    @GetMapping("/criteria")    // так делать не надо!!! это для примера
    public ResponseEntity<Page<Book>> getBooksByCriteria(PageDto pageDto, BookSearchCriteria criteria) {
        return new ResponseEntity<>(bookService.getBooksByCriteria(pageDto, criteria), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookModel bookModel) {
        return new ResponseEntity<>(bookService.addBook(bookModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookModel bookModel) {
        return new ResponseEntity<>(bookService.updateBook(id, bookModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
