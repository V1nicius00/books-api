package dev.vini.books_api.services;

import dev.vini.books_api.domain.book.Book;
import dev.vini.books_api.domain.book.BookDto;
import dev.vini.books_api.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity save(BookDto dto){
        Book newBook = new Book(dto);
        bookRepository.save(newBook);
        return ResponseEntity.ok(newBook);
    }

    public Optional<Book> findById(UUID id){
        return bookRepository.findById(id);
    }

    public ResponseEntity getAllBooks(){
        List<Book> allBooks = bookRepository.findAll();
        if(allBooks.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allBooks);
    }

    public ResponseEntity getBookById(UUID id){
        Optional<Book> book = this.findById(id);
        if(book.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book.get());
    }

    @Transactional
    public ResponseEntity updateBook(UUID id, BookDto dto) {
        Optional<Book> optionalBook = this.findById(id);
        if(optionalBook.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Book book = optionalBook.get();
        book.setPrice(dto.price());
        book.setBookName(dto.bookName());
        book.setAuthor(dto.author());
        book.setDescription(dto.description());
        book.setReleaseDate(dto.releaseDate());
        return ResponseEntity.ok(book);
    }

    @Transactional
    public ResponseEntity updateBookPrice(UUID id, BookDto dto) {
        Optional<Book> optionalBook = this.findById(id);
        if(optionalBook.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Book book = optionalBook.get();
        book.setPrice(dto.price());
        return ResponseEntity.ok(book);
    }

    @Transactional
    public ResponseEntity deleteBook(UUID id) {
        Optional<Book> optionalBook = this.findById(id);
        if(optionalBook.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        bookRepository.delete(optionalBook.get());
        return ResponseEntity.ok("Book deleted " + optionalBook.get().getBookName() + " successfully.");
    }


    public ResponseEntity getBookByName(String bookName) {
        List<Book> book = bookRepository.findByBookName(bookName);
        if(book.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
}
