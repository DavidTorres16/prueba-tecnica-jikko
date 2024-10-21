package com.example.introduction.application.services;

import com.example.introduction.domain.models.Library;
import com.example.introduction.domain.ports.in.library.CreateLibraryUseCase;
import com.example.introduction.domain.ports.in.library.DeleteLibraryUseCase;
import com.example.introduction.domain.ports.in.library.RetrieveLibraryUseCase;
import com.example.introduction.domain.ports.in.library.UpdateLibraryUseCase;

import java.util.List;
import java.util.Optional;

public class LibraryService implements CreateLibraryUseCase, RetrieveLibraryUseCase, DeleteLibraryUseCase, UpdateLibraryUseCase {

    private final CreateLibraryUseCase createLibraryUseCase;
    private final RetrieveLibraryUseCase retrieveLibraryUseCase;
    private final DeleteLibraryUseCase deleteLibraryUseCase;
    private final UpdateLibraryUseCase updateLibraryUseCase;

    public LibraryService(CreateLibraryUseCase createLibraryUseCase, RetrieveLibraryUseCase retrieveLibraryUseCase, DeleteLibraryUseCase deleteLibraryUseCase, UpdateLibraryUseCase updateLibraryUseCase) {
        this.createLibraryUseCase = createLibraryUseCase;
        this.retrieveLibraryUseCase = retrieveLibraryUseCase;
        this.deleteLibraryUseCase = deleteLibraryUseCase;
        this.updateLibraryUseCase = updateLibraryUseCase;
    }

    @Override
    public Library createLibrary(Library library) {
        return createLibraryUseCase.createLibrary(library);
    }

    @Override
    public Boolean deleteLibraryById(Integer id) {
        return deleteLibraryUseCase.deleteLibraryById(id);
    }

    @Override
    public Optional<Library> getLibraryById(Integer id) {
        return retrieveLibraryUseCase.getLibraryById(id);
    }

    @Override
    public List<Library> getAllLibraries() {
        return retrieveLibraryUseCase.getAllLibraries();
    }

    @Override
    public Optional<Library> updateAccount(Integer id, Library library) {
        return updateLibraryUseCase.updateAccount(id, library);
    }
}
