package dev.vini.books_api.controllers;

import dev.vini.books_api.domain.book.BookDto;
import dev.vini.books_api.services.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody BookDto dto){
        return bookService.save(dto);
    }

    @GetMapping
    public ResponseEntity getAllBooks(@RequestParam(required = false) String bookName){
        if(bookName == null){
            return bookService.getAllBooks();
        }
        return bookService.getBookByName(bookName);
    }

    @GetMapping("active")
    public ResponseEntity getActiveBooks(){
        return bookService.getActiveBooks();
    }

    @GetMapping("deactivated")
    public ResponseEntity getDeactivatedBooks(){
        return bookService.getDeactivatedBooks();
    }

    @GetMapping("{id}")
    public ResponseEntity getBookById(@PathVariable("id") UUID id){
        return bookService.getBookById(id);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity updateBook(@PathVariable("id") UUID id, @RequestBody BookDto dto){
        return bookService.updateBook(id, dto);
    }

    @PutMapping("price/{id}")
    @Transactional
    public ResponseEntity updateBookPrice(@PathVariable("id") UUID id, @RequestBody BookDto dto){
        return bookService.updateBookPrice(id, dto);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteBook(@PathVariable("id") UUID id){
        return bookService.deleteBook(id);
    }
}
