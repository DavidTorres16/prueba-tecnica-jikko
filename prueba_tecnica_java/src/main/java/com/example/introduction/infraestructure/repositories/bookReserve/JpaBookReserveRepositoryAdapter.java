package com.example.introduction.infraestructure.repositories.bookReserve;

import com.example.introduction.domain.models.BookReserve;
import com.example.introduction.domain.ports.out.bookReserve.BookReserveRepositoryPort;
import com.example.introduction.infraestructure.entities.BookReserveEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JpaBookReserveRepositoryAdapter implements BookReserveRepositoryPort {

    private final JpaBookReserveRepository jpaBookReserveRepository;

    @Override
    public BookReserve save(BookReserve bookReserve) {
        BookReserveEntity bookReserveEntity = BookReserveEntity.fromDomainModel(bookReserve);
        return jpaBookReserveRepository.save(bookReserveEntity).toDomainModel();
    }

    @Override
    public Optional<BookReserve> findById(Integer accountId) {
        return jpaBookReserveRepository.findById(Long.valueOf(accountId)).map(BookReserveEntity::toDomainModel);
    }

    @Override
    public List<BookReserve> findAll() {
        return jpaBookReserveRepository.findAll().stream()
                .map(BookReserveEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookReserve> update(Integer id, BookReserve reservedBook) {
        if(jpaBookReserveRepository.existsById(Long.valueOf(reservedBook.getBook().getBookId()))){
            BookReserveEntity updatedBookReserveEntity = jpaBookReserveRepository.save(BookReserveEntity.fromDomainModel(reservedBook));
            return Optional.of(updatedBookReserveEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if(jpaBookReserveRepository.existsById(Long.valueOf(id))){
            jpaBookReserveRepository.deleteById(id.longValue());
            return true;
        }
        return false;
    }
}
