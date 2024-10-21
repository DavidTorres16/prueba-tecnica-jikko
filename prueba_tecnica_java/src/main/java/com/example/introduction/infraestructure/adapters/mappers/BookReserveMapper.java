package com.example.introduction.infraestructure.adapters.mappers;

import com.example.introduction.domain.models.Book;
import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.models.User;
import com.example.introduction.infraestructure.controllers.dto.in.BookReserveDTO;
import com.example.introduction.infraestructure.controllers.dto.in.BookReserveUpdateDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BookReserveMapper {


    public static BookReserveDTO toBookReserveCreationDTO(BookReserve bookReserve) {
        if (bookReserve == null) {
            return null;
        }

        return new BookReserveDTO(
                bookReserve.getUser().getUserId(),
                bookReserve.getBook().getBookId(),
                bookReserve.getReserveDate()
        );
    }


    public static BookReserve toBookReserve(BookReserveDTO bookReserveDTO) {
        if (bookReserveDTO == null) {
            return null;
        }

        return new BookReserve(
                null,
                new User(bookReserveDTO.getUserId()),
                new Book(bookReserveDTO.getBookId()),
                bookReserveDTO.getReserveDate()
        );
    }

    public static BookReserve toBookReserve(BookReserveUpdateDTO bookReserveUpdateDTO) {
        if (bookReserveUpdateDTO == null) {
            return null;
        }

        return new BookReserve(
                bookReserveUpdateDTO.getId(),
                new User(bookReserveUpdateDTO.getUserId()),
                new Book(bookReserveUpdateDTO.getBookId()),
                bookReserveUpdateDTO.getReserveDate()
        );
    }


    public static List<BookReserveDTO> toBookReserveCreationDTOList(List<BookReserve> bookReserves) {
        if (bookReserves == null) {
            return null;
        }

        return bookReserves.stream()
                .map(BookReserveMapper::toBookReserveCreationDTO)
                .collect(Collectors.toList());
    }


    public static List<BookReserve> toBookReserveList(List<BookReserveDTO> bookReserveDTOS) {
        if (bookReserveDTOS == null) {
            return null;
        }

        return bookReserveDTOS.stream()
                .map(BookReserveMapper::toBookReserve)
                .collect(Collectors.toList());
    }

}
