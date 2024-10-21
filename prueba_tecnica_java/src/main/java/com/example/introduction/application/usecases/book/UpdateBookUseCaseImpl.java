package com.example.introduction.application.usecases.book;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.ports.in.book.UpdateBookUseCase;
import com.example.introduction.domain.ports.out.book.BookRepositoryPort;

import java.util.Optional;

public class UpdateBookUseCaseImpl implements UpdateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;


    public UpdateBookUseCaseImpl(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Optional<Book> updateProduct(Integer id, Book book) {
        return bookRepositoryPort.update(id, book);
    }
}
