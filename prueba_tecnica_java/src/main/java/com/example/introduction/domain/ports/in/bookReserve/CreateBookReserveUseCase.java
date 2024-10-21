package com.example.introduction.domain.ports.in.bookReserve;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.models.BookReserve;

public interface CreateBookReserveUseCase {

    BookReserve createBookReserve(BookReserve book);

}
