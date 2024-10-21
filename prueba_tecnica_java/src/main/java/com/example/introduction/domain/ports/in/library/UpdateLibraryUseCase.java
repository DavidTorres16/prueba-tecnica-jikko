package com.example.introduction.domain.ports.in.library;

import com.example.introduction.domain.models.Library;

import java.util.Optional;

public interface UpdateLibraryUseCase {

    Optional<Library> updateAccount(Integer id, Library library);

}
