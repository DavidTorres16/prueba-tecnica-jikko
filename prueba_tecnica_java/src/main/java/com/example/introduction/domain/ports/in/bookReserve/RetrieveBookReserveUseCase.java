package com.example.introduction.domain.ports.in.bookReserve;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.models.BookReserve;

import java.util.List;
import java.util.Optional;

public interface RetrieveBookReserveUseCase {

    Optional<BookReserve> getBookReserveById(Integer id);

    List<BookReserve> getAllBookReserves();

}
