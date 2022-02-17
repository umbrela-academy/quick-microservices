package com.example.apiclient.services;

import com.example.apiclient.client.BookConsumer;
import com.example.apiclient.domain.Book;
import com.example.apiclient.domain.BookVM;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookProcessorService {

    private final Logger log = LoggerFactory.getLogger(BookProcessorService.class);
    
    private final BookConsumer bookConsumer;

    public BookProcessorService(BookConsumer bookConsumer) {
        this.bookConsumer = bookConsumer;
    }

    public Optional<BookVM> getById(Integer id) {
        try {
            Book book = this.bookConsumer.byId(id);
            BookVM bookVM = new BookVM(book, book.getId() * 10 + " ##");
            return Optional.of(bookVM);
        } catch (FeignException e) {
            log.error("Feign exception", e);
        }
        return Optional.empty();
    }

    public Optional<List<BookVM>> getAll() {
        try {
            List<Book> books = this.bookConsumer.allBooks();

            return Optional.of(books
                    .stream()
                    .map(book -> new BookVM(book, book.getName() + " ##"))
                    .collect(Collectors.toList()));
        } catch (FeignException e) {
            log.debug("Feign exception", e);
        }
        return Optional.empty();
    }


}
