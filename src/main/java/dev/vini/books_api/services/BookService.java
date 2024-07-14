package dev.vini.books_api.services;

import dev.vini.books_api.domain.book.Book;
import dev.vini.books_api.domain.book.CreateBookDto;
import dev.vini.books_api.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity save(CreateBookDto dto){
        Book newBook = new Book(dto);
        bookRepository.save(newBook);
        return ResponseEntity.ok(newBook);
    }

}
