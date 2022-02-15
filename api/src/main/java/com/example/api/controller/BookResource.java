package com.example.api.controller;

import com.example.api.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookResource {

    @GetMapping("/{id}")
    public Book byId(@PathVariable Integer id) {
        return new Book(id, "A book name here", 999.99);
    }

    @GetMapping("/all")
    public List<Book> all() {
        return List.of(
                new Book(411, "411 Book", 411.11),
                new Book(412, "412 Book", 412.12),
                new Book(413, "413 Book", 412.13)
        );
    }
}
