package org.midouz.controller;

import lombok.RequiredArgsConstructor;
import org.midouz.dto.BookDTO;
import org.midouz.entity.Book;
import org.midouz.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
