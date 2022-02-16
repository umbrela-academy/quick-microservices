package com.example.apiclient.controller;

import com.example.apiclient.domain.BookVM;
import com.example.apiclient.services.BookProcessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book-ad")
public class AdBookResource {

    private final BookProcessorService bookProcessorService;

    public AdBookResource(BookProcessorService bookProcessorService) {
        this.bookProcessorService = bookProcessorService;
    }

    // Enable if OAuth configured
    //@PreAuthorize("#oauth2.hasScope('custom_scope_name')")
    @GetMapping("/{id}")
    public ResponseEntity<BookVM> byId(@PathVariable Integer id) {
        Optional<BookVM> bookVM = this.bookProcessorService.getById(id);
        return bookVM.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookVM>> all() {
        Optional<List<BookVM>> bookVMs = this.bookProcessorService.getAll();
        return bookVMs.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
