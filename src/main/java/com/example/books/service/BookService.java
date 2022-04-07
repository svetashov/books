package com.example.books.service;

import com.example.books.dto.PageDto;
import com.example.books.entity.Book;
import com.example.books.model.BookModel;
import org.springframework.data.domain.Page;

public interface BookService {

    Book getBookById(Long id);

    Page<Book> getBooks(PageDto pageDto);

    Book addBook(BookModel bookModel);

    Book updateBook(Long id, BookModel bookModel);

    void deleteById(Long id);

}
