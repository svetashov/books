package com.example.books.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/hello")
    public ResponseEntity<String> testHello() {
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }

    @GetMapping(value = "/bye")
    public ResponseEntity<String> testBye() {
        return new ResponseEntity<String>("Bye world", HttpStatus.OK);
    }
}
