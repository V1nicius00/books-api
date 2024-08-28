package dev.vini.books_api.repositories;

import dev.vini.books_api.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByBookName(String bookName);
    List<Book> findByActiveTrue();
    List<Book> findByActiveFalse();
    List<Book> findByPriceLessThan(Double price);
    List<Book> findByPriceGreaterThan(Double price);
}
