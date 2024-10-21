package com.example.introduction.application.usecases.bookReserve;

import com.example.introduction.domain.ports.in.bookReserve.DeleteBookReserveUseCase;
import com.example.introduction.domain.ports.out.bookReserve.BookReserveRepositoryPort;

public class DeleteBookReserveUseCaseImpl implements DeleteBookReserveUseCase {

    private final BookReserveRepositoryPort bookReserveRepositoryPort;

    public DeleteBookReserveUseCaseImpl(BookReserveRepositoryPort bookReserveRepositoryPort) {
        this.bookReserveRepositoryPort = bookReserveRepositoryPort;
    }

    @Override
    public Boolean deleteBookReserveById(Integer id) {
        return bookReserveRepositoryPort.deleteById(id);
    }
}
