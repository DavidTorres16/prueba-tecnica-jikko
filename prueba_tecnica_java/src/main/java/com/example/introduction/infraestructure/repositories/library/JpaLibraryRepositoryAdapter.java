package com.example.introduction.infraestructure.repositories.library;

import com.example.introduction.domain.models.Library;
import com.example.introduction.domain.ports.out.library.LibraryRepositoryPort;
import com.example.introduction.infraestructure.entities.LibraryEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaLibraryRepositoryAdapter implements LibraryRepositoryPort {

    private final JpaLibraryRepository jpaLibraryRepository;

    @Override
    public Library save(Library library) {
        LibraryEntity libraryEntity = LibraryEntity.fromDomainModel(library);
        return jpaLibraryRepository.save(libraryEntity).toDomainModel();
    }

    @Override
    public Optional<Library> findById(Integer accountId) {
        return jpaLibraryRepository.findById(Long.valueOf(accountId)).map(LibraryEntity::toDomainModel);
    }

    @Override
    public List<Library> findAll() {
        return jpaLibraryRepository.findAll().stream()
                .map(LibraryEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Library> update(Integer id, Library library) {
        if(jpaLibraryRepository.existsById(Long.valueOf(library.getLibraryId()))){
            LibraryEntity updatedLibraryEntity = jpaLibraryRepository.save(LibraryEntity.fromDomainModel(library));
            return Optional.of(updatedLibraryEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(jpaLibraryRepository.existsById(Long.valueOf(id))){
            jpaLibraryRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
