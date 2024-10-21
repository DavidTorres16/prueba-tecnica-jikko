package com.example.introduction.domain.ports.in.book;

import com.example.introduction.domain.models.Book;

import java.util.Optional;

public interface UpdateBookUseCase {

    Optional<Book> updateProduct(Integer id, Book book);

}
