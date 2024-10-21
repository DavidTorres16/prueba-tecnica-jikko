package com.example.introduction.application.usecases.library;

import com.example.introduction.domain.models.Library;
import com.example.introduction.domain.ports.in.library.UpdateLibraryUseCase;
import com.example.introduction.domain.ports.out.library.LibraryRepositoryPort;

import java.util.Optional;

public class UpdateLibraryUseCaseImpl implements UpdateLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public UpdateLibraryUseCaseImpl(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }

    @Override
    public Optional<Library> updateAccount(Integer id, Library library) {
        return libraryRepositoryPort.update(id, library);
    }
}
