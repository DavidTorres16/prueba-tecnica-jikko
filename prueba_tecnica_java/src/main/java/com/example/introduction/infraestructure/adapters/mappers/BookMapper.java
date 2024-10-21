package com.example.introduction.infraestructure.adapters.mappers;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.models.Library;
import com.example.introduction.infraestructure.controllers.dto.in.BookDTO;
import com.example.introduction.infraestructure.controllers.dto.in.BookUpdateDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDTO toBookCreationDTO(Book book) {
        if (book == null) {
            return null;
        }

        return new BookDTO(
                book.getBookCode(),
                book.getName(),
                book.getBookGenre(),
                book.getIsAvailable(),
                book.getLibrary() != null ? book.getLibrary().getLibraryId() : null
        );
    }


    public static Book toBook(BookUpdateDTO bookUpdateDTO) {
        if (bookUpdateDTO == null) {
            return null;
        }

        return new Book(
                bookUpdateDTO.getId(),
                bookUpdateDTO.getBookCode(),
                bookUpdateDTO.getName(),
                bookUpdateDTO.getBookGenre(),
                bookUpdateDTO.getIsAvailable(),
                new Library(bookUpdateDTO.getLibraryId()),
                null
        );
    }

    public static Book toBook(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }

        return new Book(
                null,
                bookDTO.getBookCode(),
                bookDTO.getName(),
                bookDTO.getBookGenre(),
                bookDTO.getIsAvailable(),
                new Library(bookDTO.getLibraryId()),
                null
        );
    }


    public static List<BookDTO> toBookCreationDTOList(List<Book> books) {
        if (books == null) {
            return null;
        }

        return books.stream()
                .map(BookMapper::toBookCreationDTO)
                .collect(Collectors.toList());
    }


    public static List<Book> toBookList(List<BookDTO> bookDTOS) {
        if (bookDTOS == null) {
            return null;
        }

        return bookDTOS.stream()
                .map(BookMapper::toBook)
                .collect(Collectors.toList());
    }
}
