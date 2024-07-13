package dev.vini.books_api.domain.book;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id")
    private UUID id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}