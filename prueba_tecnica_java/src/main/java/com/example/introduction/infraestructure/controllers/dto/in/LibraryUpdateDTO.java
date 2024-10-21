package com.example.introduction.infraestructure.controllers.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LibraryUpdateDTO {

    private Integer id;
    private String Name;
    private Boolean isActive;

}
