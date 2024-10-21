package com.example.introduction.infraestructure.controllers.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookReserveUpdateDTO {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private LocalDate reserveDate;

}
