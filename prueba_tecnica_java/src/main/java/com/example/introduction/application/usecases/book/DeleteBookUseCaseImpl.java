package com.example.introduction.application.usecases.book;

import com.example.introduction.domain.ports.in.book.DeleteBookUseCase;
import com.example.introduction.domain.ports.out.book.BookRepositoryPort;

public class DeleteBookUseCaseImpl implements DeleteBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public DeleteBookUseCaseImpl(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        return bookRepositoryPort.deleteById(id);
    }
}
