package com.example.introduction.infraestructure.entities;

import com.example.introduction.domain.models.BookReserve;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BookReserve")
@AllArgsConstructor
@NoArgsConstructor
public class BookReserveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private BookEntity book;

    @Column(name="reserveDate")
    private LocalDate reserveDate;

    public static BookReserveEntity fromDomainModel(BookReserve bookReserve){
        return new BookReserveEntity(bookReserve.getId(),
                UserEntity.fromDomainModel(bookReserve.getUser()),
                BookEntity.fromDomainModel(bookReserve.getBook()),
                bookReserve.getReserveDate()
        );
    }

    public BookReserve toDomainModel(){
        return new BookReserve(this.id, this.user.toDomainModelWithoutBooks(), this.book.toDomainModel(), this.reserveDate);
    }

    public BookReserve toDomainModelWithoutUser(){
        return new BookReserve(this.id, null, this.book.toDomainModel(), this.reserveDate);
    }

    public static List<BookReserveEntity> fromDomainModelList(List<BookReserve> bookList){
        List<BookReserveEntity> bookEntityList = new ArrayList<>();
        for (BookReserve book: bookList){
            bookEntityList.add(fromDomainModel(book));
        }
        return bookEntityList;
    }

    public static List<BookReserve> toDomainModelList(List<BookReserveEntity> bookEntityList){
        List<BookReserve> bookList = new ArrayList<>();
        for (BookReserveEntity bookEntity: bookEntityList){
            bookList.add(bookEntity.toDomainModelWithoutUser());
        }
        return bookList;
    }

}
