package com.example.books.handler;

import com.example.books.dto.ErrorDto;
import com.example.books.exception.ResourceAlreadyExistsException;
import com.example.books.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public @ResponseBody ResponseEntity<ErrorDto> handleResourceNotFoundException(Exception e) {
        Date timestamp = new Date(System.currentTimeMillis());      // не очень
        return new ResponseEntity<>(
                new ErrorDto(e.getMessage(), timestamp),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public @ResponseBody ResponseEntity<ErrorDto> handleResourceAlreadyExistsException(Exception e) {
        Date timestamp = new Date(System.currentTimeMillis());      // не очень
        return new ResponseEntity<>(
                new ErrorDto(e.getMessage(), timestamp),
                HttpStatus.CONFLICT
        );
    }

}
