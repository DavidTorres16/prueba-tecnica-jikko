package com.example.introduction.infraestructure.controllers.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {

    private Integer age;
    private String name;
    private String lastName;
    private Integer personalId;

}
