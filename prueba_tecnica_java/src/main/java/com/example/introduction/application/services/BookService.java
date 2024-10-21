package com.example.introduction.application.services;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.ports.in.book.CreateBookUseCase;
import com.example.introduction.domain.ports.in.book.DeleteBookUseCase;
import com.example.introduction.domain.ports.in.book.RetrieveBookUseCase;
import com.example.introduction.domain.ports.in.book.UpdateBookUseCase;

import java.util.List;
import java.util.Optional;

public class BookService implements RetrieveBookUseCase, DeleteBookUseCase, UpdateBookUseCase, CreateBookUseCase {

    private final RetrieveBookUseCase retrieveBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final CreateBookUseCase createBookUseCase;

    public BookService(RetrieveBookUseCase retrieveBookUseCase, DeleteBookUseCase deleteBookUseCase, UpdateBookUseCase updateBookUseCase, CreateBookUseCase createBookUseCase) {
        this.retrieveBookUseCase = retrieveBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.createBookUseCase = createBookUseCase;
    }

    @Override
    public Book createBook(Book book) {
        return createBookUseCase.createBook(book);
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        return deleteBookUseCase.deleteProductById(id);
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return retrieveBookUseCase.getBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return retrieveBookUseCase.getAllBooks();
    }

    @Override
    public Optional<Book> updateProduct(Integer id, Book book) {
        return updateBookUseCase.updateProduct(id, book);
    }
}
