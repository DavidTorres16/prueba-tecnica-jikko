package com.example.introduction.infraestructure.entities;

import com.example.introduction.domain.models.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Book")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BookId")
    private Integer bookId;

    @Column(name="bookCode", unique=true)
    private String bookCode;

    @Column(name="name")
    private String name;

    @Column(name="bookGenre")
    private Integer bookGenre;

    @Column(name="isAvailable")
    private Boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libraryId")
    private LibraryEntity library;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookReserveEntity> reservedBooks;

    public static BookEntity fromDomainModel(Book book){
        return new BookEntity(book.getBookId(),
                book.getBookCode(),
                book.getName(),
                book.getBookGenre(),
                book.getIsAvailable(),
                book.getLibrary() != null ? LibraryEntity.fromDomainModel(book.getLibrary()) : null,
                book.getReservedBooks() != null ? BookReserveEntity.fromDomainModelList(book.getReservedBooks()): new ArrayList<>()
        );
    }

    public static List<BookEntity> fromDomainModelList(List<Book> bookList){
        List<BookEntity> bookEntityList = new ArrayList<>();
        for (Book book: bookList){
            bookEntityList.add(fromDomainModel(book));
        }
        return bookEntityList;
    }

    public static List<Book> toDomainModelList(List<BookEntity> bookEntityList){
        List<Book> bookList = new ArrayList<>();
        for (BookEntity bookEntity: bookEntityList){
            bookList.add(bookEntity.toDomainModel());
        }
        return bookList;
    }

    public Book toDomainModel(){
        return new Book(this.bookId, this.bookCode, this.name, this.bookGenre, this.isAvailable, null, null);
    }

}
