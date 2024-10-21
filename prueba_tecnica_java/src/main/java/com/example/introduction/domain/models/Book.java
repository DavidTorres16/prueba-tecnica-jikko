package com.example.introduction.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private Integer bookId;
    private String bookCode;
    private String name;
    private Integer bookGenre;
    private Boolean isAvailable;
    private Library library;
    private List<BookReserve> reservedBooks;

    public Book(Integer bookId) {
        this.bookId = bookId;
    }
}
