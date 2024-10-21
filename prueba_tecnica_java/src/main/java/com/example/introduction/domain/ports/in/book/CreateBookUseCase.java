package com.example.introduction.domain.ports.in.book;

import com.example.introduction.domain.models.Book;

public interface CreateBookUseCase {

    Book createBook(Book book);

}
