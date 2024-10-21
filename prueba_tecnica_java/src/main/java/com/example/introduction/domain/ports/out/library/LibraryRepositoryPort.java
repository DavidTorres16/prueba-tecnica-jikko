package com.example.introduction.domain.ports.out.library;

import com.example.introduction.domain.models.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepositoryPort {

    Library save(Library library);

    Optional<Library> findById(Integer LibraryId);

    List<Library> findAll();

    Optional<Library> update(Integer id, Library library);

    Boolean deleteById(Integer id);

}
