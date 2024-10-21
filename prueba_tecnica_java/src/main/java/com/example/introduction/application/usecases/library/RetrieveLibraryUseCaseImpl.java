package com.example.introduction.application.usecases.library;

import com.example.introduction.domain.models.Library;
import com.example.introduction.domain.ports.in.library.RetrieveLibraryUseCase;
import com.example.introduction.domain.ports.out.library.LibraryRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveLibraryUseCaseImpl implements RetrieveLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public RetrieveLibraryUseCaseImpl(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }

    @Override
    public Optional<Library> getLibraryById(Integer id) {
        return libraryRepositoryPort.findById(id);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepositoryPort.findAll();
    }
}
