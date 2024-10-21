package com.example.introduction.application.usecases.bookReserve;


import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.ports.in.bookReserve.UpdateBookReserveUseCase;
import com.example.introduction.domain.ports.out.bookReserve.BookReserveRepositoryPort;

import java.util.Optional;

public class UpdateBookReserveUseCaseImpl implements UpdateBookReserveUseCase {

    private final BookReserveRepositoryPort bookReserveRepositoryPort;

    public UpdateBookReserveUseCaseImpl(BookReserveRepositoryPort BookReserveRepositoryPort) {
        this.bookReserveRepositoryPort = BookReserveRepositoryPort;
    }

    @Override
    public Optional<BookReserve> updateBookReserve(Integer id, BookReserve bookReserve) {
        return bookReserveRepositoryPort.update(id, bookReserve);
    }
}
