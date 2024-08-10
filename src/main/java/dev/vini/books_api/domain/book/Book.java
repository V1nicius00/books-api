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

    @Column(name = "active")
    private boolean active;

    public Book() {
    }

    public Book (UUID id, String bookName, String description, String author, Double price, LocalDate releaseDate) {
        this.id = id;
        this.bookName = bookName;
        this.description = description;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Book (BookDto dto){
        this.bookName = dto.bookName();
        this.description = dto.description();
        this.author = dto.author();
        this.price = dto.price();
        this.releaseDate = dto.releaseDate();
        this.active = true;
    }
}
