package com.example.books.serviceimpl;

import com.example.books.dto.PageDto;
import com.example.books.entity.Author;
import com.example.books.entity.Book;
import com.example.books.exception.ResourceAlreadyExistsException;
import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.BookModel;
import com.example.books.repository.AuthorRepository;
import com.example.books.repository.BookRepository;
import com.example.books.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @Override
    public Book getBookById(Long id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The book with id=" + id + " does not exist."));
    }

    @Override
    public Page<Book> getBooks(PageDto pageDto) {
        return bookRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Book addBook(BookModel bookModel) {
        Author author = authorRepository
                .findById(bookModel.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The author with id=" + bookModel.getAuthorId() + " does not exist."));
        if (bookRepository.existsByNameAndAuthor(bookModel.getName(), author)) {
            throw new ResourceAlreadyExistsException("The book with such name and author already exists.");
        }
        Book book = new Book(bookModel.getName(), bookModel.getYear(), author);
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            throw new ResourceNotFoundException("The book with id=" + book.getId() + " does not exist.");
        }
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
