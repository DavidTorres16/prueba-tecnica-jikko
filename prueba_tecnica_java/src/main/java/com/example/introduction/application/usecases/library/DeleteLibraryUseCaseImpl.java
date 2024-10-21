package com.example.introduction.application.usecases.library;

import com.example.introduction.domain.ports.in.library.DeleteLibraryUseCase;
import com.example.introduction.domain.ports.out.library.LibraryRepositoryPort;

public class DeleteLibraryUseCaseImpl implements DeleteLibraryUseCase {

    private final LibraryRepositoryPort libraryRepositoryPort;

    public DeleteLibraryUseCaseImpl(LibraryRepositoryPort libraryRepositoryPort) {
        this.libraryRepositoryPort = libraryRepositoryPort;
    }

    @Override
    public Boolean deleteLibraryById(Integer id) {
        return libraryRepositoryPort.deleteById(id);
    }
}
