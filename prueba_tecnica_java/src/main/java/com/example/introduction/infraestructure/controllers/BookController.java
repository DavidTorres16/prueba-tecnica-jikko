package com.example.introduction.infraestructure.controllers;

import com.example.introduction.application.services.BookService;
import com.example.introduction.domain.models.Book;
import com.example.introduction.infraestructure.adapters.mappers.BookMapper;
import com.example.introduction.infraestructure.controllers.dto.in.BookDTO;
import com.example.introduction.infraestructure.controllers.dto.in.BookUpdateDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book/")
@AllArgsConstructor
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO book){
        Book newBook = new Book();
        try{
            newBook = bookService.createBook(BookMapper.toBook(book));
        } catch (Exception e){
            log.error("Failed: create book", e);
        }
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<Book> findBook(@RequestParam Integer libraryId){
        Book book = new Book();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Book> optBook= bookService.getBookById(libraryId);
            if (optBook.isPresent()){
                book = optBook.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find book by id", e);
        }
        return new ResponseEntity<>(book, status);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBook(){
        List<Book> bookReserveList = new ArrayList<>();
        try{
            bookReserveList = bookService.getAllBooks();
        } catch(Exception e){
            log.error("Failed: find all books", e);
        }
        return new ResponseEntity<>(bookReserveList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody BookUpdateDTO book){
        Book updatedBook = new Book();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Book> optBook = bookService.updateProduct(book.getId(), BookMapper.toBook(book));
            if(optBook.isPresent()){
                updatedBook = optBook.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: update book", e);
        }

        return new ResponseEntity<>(updatedBook, status);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Integer bookId){
        try{
            bookService.getBookById(bookId);
        } catch(Exception e){
            log.error("Failed: delete book", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
