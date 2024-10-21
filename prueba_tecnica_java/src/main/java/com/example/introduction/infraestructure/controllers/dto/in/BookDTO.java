package com.example.introduction.infraestructure.controllers.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookDTO {

    private String bookCode;
    private String name;
    private Integer bookGenre;
    private Boolean isAvailable;
    private Integer libraryId;

}
