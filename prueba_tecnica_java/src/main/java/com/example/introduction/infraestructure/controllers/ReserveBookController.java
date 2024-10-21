package com.example.introduction.infraestructure.controllers;

import com.example.introduction.application.services.BookReserveService;
import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.infraestructure.adapters.mappers.BookReserveMapper;
import com.example.introduction.infraestructure.controllers.dto.in.BookReserveDTO;
import com.example.introduction.infraestructure.controllers.dto.in.BookReserveUpdateDTO;
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
@RequestMapping("bookReserve/")
@AllArgsConstructor
public class ReserveBookController {
    private static final Logger log = LoggerFactory.getLogger(ReserveBookController.class);
    private final BookReserveService bookReserveService;

    @PostMapping
    public ResponseEntity<BookReserve> createBookReserve(@RequestBody BookReserveDTO book){
        BookReserve newBookReserve = new BookReserve();
        try{
            newBookReserve = bookReserveService.createBookReserve(BookReserveMapper.toBookReserve(book));
        } catch (Exception e){
            log.error("Failed: create book reserve", e);
        }
        return new ResponseEntity<>(newBookReserve, HttpStatus.CREATED);
    }

    @GetMapping("/{bookReserveId}")
    public ResponseEntity<BookReserve> findBookReserve(@RequestParam Integer bookReserveId){
        BookReserve bookReserve = new BookReserve();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<BookReserve> optBookReserve= bookReserveService.getBookReserveById(bookReserveId);
            if (optBookReserve.isPresent()){
                bookReserve = optBookReserve.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find bookReserve by id", e);
        }
        return new ResponseEntity<>(bookReserve, status);
    }

    @GetMapping
    public ResponseEntity<List<BookReserve>> findAllBookReserves(){
        List<BookReserve> bookReserveList = new ArrayList<>();
        try{
            bookReserveList = bookReserveService.getAllBookReserves();
        } catch(Exception e){
            log.error("Failed: find all book reserves", e);
        }
        return new ResponseEntity<>(bookReserveList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookReserve> updateBookReserve(@RequestBody BookReserveUpdateDTO bookReserve){
        BookReserve updatedBookReserve = new BookReserve();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<BookReserve> optBookReserve = bookReserveService.updateBookReserve(bookReserve.getId(), BookReserveMapper.toBookReserve(bookReserve));
            if(optBookReserve.isPresent()){
                updatedBookReserve = optBookReserve.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: update bookReserve", e);
        }

        return new ResponseEntity<>(updatedBookReserve, status);
    }

    @DeleteMapping("/{bookReserveId}")
    public ResponseEntity<Boolean> deleteBookReserve(@PathVariable Integer bookReserveId){
        try{
            bookReserveService.deleteBookReserveById(bookReserveId);
        } catch(Exception e){
            log.error("Failed: delete book reserve", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
