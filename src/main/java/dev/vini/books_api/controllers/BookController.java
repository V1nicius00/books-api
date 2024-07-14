package dev.vini.books_api.controllers;

import dev.vini.books_api.domain.book.Book;
import dev.vini.books_api.domain.book.CreateBookDto;
import dev.vini.books_api.services.BookService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody CreateBookDto dto){
        return bookService.save(dto);
    }

}
