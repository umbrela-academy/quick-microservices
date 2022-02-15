package com.example.apiclient.client;

import com.example.apiclient.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="API-Core")
public interface BookConsumer {

    @GetMapping("/book/{id}")
    public Book byId(@PathVariable Integer id);

    @GetMapping("/book/all")
    public List<Book> allBooks();
}
