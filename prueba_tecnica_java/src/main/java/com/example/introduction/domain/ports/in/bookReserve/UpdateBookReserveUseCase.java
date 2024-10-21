package com.example.introduction.domain.ports.in.bookReserve;

import com.example.introduction.domain.models.BookReserve;

import java.util.Optional;

public interface UpdateBookReserveUseCase {

    Optional<BookReserve> updateBookReserve(Integer id, BookReserve book);

}
