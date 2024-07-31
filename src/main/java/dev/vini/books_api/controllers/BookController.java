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
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity getAllBooks(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String status){
        if(name != null){
            return bookService.getBookByName(name);
        }
        boolean bookStatus = (status != null && status.equals("deactivated")) ? false : true;
        return bookService.getAllBooks(bookStatus);
    }

    @GetMapping("priceLowerThan/{price}")
    public ResponseEntity getBooksByPriceLessThan(@PathVariable("price") Double price){
        return bookService.getBooksByPriceLessThan(price);
    }

    @GetMapping("priceGreaterThan/{price}")
    public ResponseEntity getBooksByPriceGreaterThan(@PathVariable("price") Double price){
        return bookService.getBooksByPriceGreaterThan(price);
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
