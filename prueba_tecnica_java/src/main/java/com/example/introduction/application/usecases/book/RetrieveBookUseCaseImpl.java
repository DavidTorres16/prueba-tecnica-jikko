package com.example.introduction.application.usecases.book;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.ports.in.book.RetrieveBookUseCase;
import com.example.introduction.domain.ports.out.book.BookRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveBookUseCaseImpl implements RetrieveBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public RetrieveBookUseCaseImpl(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepositoryPort.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryPort.findAll();
    }
}
