package com.example.introduction.domain.ports.out.book;

import com.example.introduction.domain.models.Book;

import java.util.Optional;
import java.util.List;

public interface BookRepositoryPort {

    Book save(Book book);

    Optional<Book> findById(Integer id);

    List<Book> findAll();

    Optional<Book> update(Integer id, Book book);

    Boolean deleteById(Integer id);

}
