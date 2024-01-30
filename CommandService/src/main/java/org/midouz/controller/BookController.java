package org.midouz.controller;

import lombok.RequiredArgsConstructor;
import org.midouz.dto.CreateBookRequest;
import org.midouz.entity.Book;
import org.midouz.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book createBook(@RequestBody CreateBookRequest request) {
        return bookService.createBook(request);
    }
}
