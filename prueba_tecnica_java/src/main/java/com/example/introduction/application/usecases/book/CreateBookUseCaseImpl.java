package com.example.introduction.application.usecases.book;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.ports.in.book.CreateBookUseCase;
import com.example.introduction.domain.ports.out.book.BookRepositoryPort;

public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final BookRepositoryPort bookRepositoryPort;

    public CreateBookUseCaseImpl(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Override
    public Book createBook(Book book) {
        return bookRepositoryPort.save(book);
    }
}
