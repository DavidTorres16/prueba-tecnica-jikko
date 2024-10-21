package com.example.introduction.infraestructure.controllers;

import com.example.introduction.application.services.LibraryService;
import com.example.introduction.domain.models.Library;
import com.example.introduction.infraestructure.adapters.mappers.LibraryMapper;
import com.example.introduction.infraestructure.controllers.dto.in.LibraryDTO;
import com.example.introduction.infraestructure.controllers.dto.in.LibraryUpdateDTO;
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
@RequestMapping("library/")
@AllArgsConstructor
public class LibraryController {

    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Library> createLibrary(@RequestBody LibraryDTO library){
        Library newLibrary = new Library();
        try{
            newLibrary = libraryService.createLibrary(LibraryMapper.toLibrary(library));
        } catch (Exception e){
            log.error("Failed: create library", e);
        }
        return new ResponseEntity<>(newLibrary, HttpStatus.CREATED);
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<Library> findLibrary(@RequestParam Integer libraryId){
        Library library = new Library();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Library> optLibrary= libraryService.getLibraryById(libraryId);
            if (optLibrary.isPresent()){
                library = optLibrary.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: find library by id", e);
        }
        return new ResponseEntity<>(library, status);
    }

    @GetMapping
    public ResponseEntity<List<Library>> findAllUsers(){
        List<Library> libraryList = new ArrayList<>();
        try{
            libraryList = libraryService.getAllLibraries();
        } catch(Exception e){
            log.error("Failed: find all library", e);
        }
        return new ResponseEntity<>(libraryList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Library> updateLibrary(@RequestBody LibraryUpdateDTO library){
        Library updatedLibrary = new Library();
        HttpStatus status = HttpStatus.NOT_FOUND;
        try{
            Optional<Library> optUser = libraryService.updateAccount(library.getId(), LibraryMapper.toLibrary(library));
            if(optUser.isPresent()){
                updatedLibrary = optUser.get();
                status = HttpStatus.OK;
            }
        } catch(Exception e){
            log.error("Failed: update library", e);
        }

        return new ResponseEntity<>(updatedLibrary, status);
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer libraryId){
        try{
            libraryService.deleteLibraryById(libraryId);
        } catch(Exception e){
            log.error("Failed: delete library", e);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
