package com.example.introduction.domain.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer userId;
    private Integer age;
    private String name;
    private String lastName;
    private Integer personalId;
    private List<BookReserve> reservedBooks;

    public User(Integer userId) {
        this.userId = userId;
    }
}
