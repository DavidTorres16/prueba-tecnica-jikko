package com.example.introduction.domain.ports.out.bookReserve;

import com.example.introduction.domain.models.BookReserve;

import java.util.List;
import java.util.Optional;

public interface BookReserveRepositoryPort {

    BookReserve save(BookReserve book);

    Optional<BookReserve> findById(Integer id);

    List<BookReserve> findAll();

    Optional<BookReserve> update(Integer id, BookReserve book);

    Boolean deleteById(Integer id);

}
