package com.example.introduction.application.usecases.bookReserve;

import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.ports.in.bookReserve.RetrieveBookReserveUseCase;
import com.example.introduction.domain.ports.out.bookReserve.BookReserveRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveBookReserveUseCaseImpl implements RetrieveBookReserveUseCase {

    private final BookReserveRepositoryPort bookReserveRepositoryPort;

    public RetrieveBookReserveUseCaseImpl(BookReserveRepositoryPort bookReserveRepositoryPort) {
        this.bookReserveRepositoryPort = bookReserveRepositoryPort;
    }

    @Override
    public Optional<BookReserve> getBookReserveById(Integer id) {
        return bookReserveRepositoryPort.findById(id);
    }

    @Override
    public List<BookReserve> getAllBookReserves() {
        return bookReserveRepositoryPort.findAll();
    }
}
