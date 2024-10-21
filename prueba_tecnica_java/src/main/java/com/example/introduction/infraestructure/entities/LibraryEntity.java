package com.example.introduction.infraestructure.entities;

import com.example.introduction.domain.models.Library;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Library")
@AllArgsConstructor
@NoArgsConstructor
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="libraryId")
    private Integer LibraryId;

    @Column(name="name")
    private String Name;

    @Column(name="isActive")
    private Boolean isActive;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<BookEntity> bookList;

    public static LibraryEntity fromDomainModel(Library library){
        return new LibraryEntity(library.getLibraryId(),
                library.getName(),
                library.getIsActive(),
                library.getBookList() != null ?BookEntity.fromDomainModelList(library.getBookList()) : new ArrayList<>()
        );
    }

    public Library toDomainModel(){
        return new Library(this.LibraryId, this.Name, this.isActive, BookEntity.toDomainModelList(this.bookList));
    }
}
