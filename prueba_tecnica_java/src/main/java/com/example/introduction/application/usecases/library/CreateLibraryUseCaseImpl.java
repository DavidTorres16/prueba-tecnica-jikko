package com.example.introduction.application.usecases.library;

import com.example.introduction.domain.models.Library;
import com.example.introduction.domain.ports.in.library.CreateLibraryUseCase;
import com.example.introduction.domain.ports.out.library.LibraryRepositoryPort;

public class CreateLibraryUseCaseImpl implements CreateLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public CreateLibraryUseCaseImpl(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }

    @Override
    public Library createLibrary(Library library) {
        return libraryRepositoryPort.save(library);
    }
}
