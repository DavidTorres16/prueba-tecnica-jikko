package com.example.introduction.domain.ports.in.book;

import com.example.introduction.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface RetrieveBookUseCase {

    Optional<Book> getBookById(Integer id);

    List<Book> getAllBooks();

}
