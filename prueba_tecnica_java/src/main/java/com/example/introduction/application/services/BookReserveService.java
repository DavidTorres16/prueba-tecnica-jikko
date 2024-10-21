package com.example.introduction.application.services;

import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.ports.in.bookReserve.DeleteBookReserveUseCase;
import com.example.introduction.domain.ports.in.bookReserve.RetrieveBookReserveUseCase;
import com.example.introduction.domain.ports.in.bookReserve.UpdateBookReserveUseCase;
import com.example.introduction.domain.ports.in.bookReserve.CreateBookReserveUseCase;

import java.util.List;
import java.util.Optional;


public class BookReserveService implements RetrieveBookReserveUseCase, DeleteBookReserveUseCase, UpdateBookReserveUseCase, CreateBookReserveUseCase {

    private final RetrieveBookReserveUseCase retrieveBookReserveUseCase;
    private final DeleteBookReserveUseCase deleteBookReserveUseCase;
    private final UpdateBookReserveUseCase updateBookReserveUseCase;
    private final CreateBookReserveUseCase createBookReserveUseCase;

    public BookReserveService(RetrieveBookReserveUseCase retrieveBookReserveUseCase, DeleteBookReserveUseCase deleteBookReserveUseCase, UpdateBookReserveUseCase updateBookReserveUseCase, CreateBookReserveUseCase createBookReserveUseCase) {
        this.retrieveBookReserveUseCase = retrieveBookReserveUseCase;
        this.deleteBookReserveUseCase = deleteBookReserveUseCase;
        this.updateBookReserveUseCase = updateBookReserveUseCase;
        this.createBookReserveUseCase = createBookReserveUseCase;
    }

    @Override
    public BookReserve createBookReserve(BookReserve book) {
        return createBookReserveUseCase.createBookReserve(book);
    }

    @Override
    public Boolean deleteBookReserveById(Integer id) {
        return deleteBookReserveUseCase.deleteBookReserveById(id);
    }

    @Override
    public Optional<BookReserve> getBookReserveById(Integer id) {
        return retrieveBookReserveUseCase.getBookReserveById(id);
    }

    @Override
    public List<BookReserve> getAllBookReserves() {
        return retrieveBookReserveUseCase.getAllBookReserves();
    }

    @Override
    public Optional<BookReserve> updateBookReserve(Integer id, BookReserve book) {
        return updateBookReserveUseCase.updateBookReserve(id, book);
    }
}
