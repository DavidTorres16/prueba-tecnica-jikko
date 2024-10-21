package com.example.introduction.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Library {

    private Integer LibraryId;
    private String Name;
    private Boolean isActive;
    private List<Book> bookList;

    public Library(Integer libraryId){
        this.LibraryId = libraryId;
    }

}
