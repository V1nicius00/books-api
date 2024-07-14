package dev.vini.books_api.domain.book;

import java.time.LocalDate;

public record CreateBookDto(String bookName,
                            String description,
                            String author,
                            Double price,
                            LocalDate releaseDate) {
}
