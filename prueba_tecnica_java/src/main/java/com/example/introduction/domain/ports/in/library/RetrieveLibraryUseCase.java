package com.example.introduction.domain.ports.in.library;

import com.example.introduction.domain.models.Library;

import java.util.List;
import java.util.Optional;

public interface RetrieveLibraryUseCase {

    Optional<Library> getLibraryById(Integer id);

    List<Library> getAllLibraries();

}
