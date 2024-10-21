package com.example.introduction.application.usecases.bookReserve;

import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.ports.in.bookReserve.CreateBookReserveUseCase;
import com.example.introduction.domain.ports.out.bookReserve.BookReserveRepositoryPort;

public class CreateBookReserveUseCaseImpl implements CreateBookReserveUseCase {

    private final BookReserveRepositoryPort bookReserveRepositoryPort;

    public CreateBookReserveUseCaseImpl(BookReserveRepositoryPort bookReserveRepositoryPort) {
        this.bookReserveRepositoryPort = bookReserveRepositoryPort;
    }

    @Override
    public BookReserve createBookReserve(BookReserve bookReserve) {return bookReserveRepositoryPort.save(bookReserve);}
}
