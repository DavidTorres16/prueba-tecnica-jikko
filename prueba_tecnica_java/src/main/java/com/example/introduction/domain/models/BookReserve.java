package com.example.introduction.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookReserve {

    private Integer id;
    private User user;
    private Book book;
    private LocalDate reserveDate;

}
